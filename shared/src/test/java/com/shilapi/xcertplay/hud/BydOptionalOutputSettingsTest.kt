package com.shilapi.xcertplay.hud

import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ApplicationInfo
import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.Signature
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowBuild

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29], manifest = Config.NONE)
class BydOptionalOutputSettingsTest {
    @Test fun optionalOutputsDefaultOffAndKeepExplicitPreviousSelections() {
        val app = RuntimeEnvironment.getApplication()
        val prefs = app.getSharedPreferences("diplay_byd_outputs", Context.MODE_PRIVATE)
        prefs.edit().clear().commit()
        assertFalse(BydOutputSettings.hudSong(app))
        assertEquals(BydOemClusterHold.OFF, BydOutputSettings.oemClusterHold(app))
        prefs.edit().putBoolean("oem_cluster_freeze", true).commit()
        assertEquals(BydOemClusterHold.PACKAGE, BydOutputSettings.oemClusterHold(app))
        BydOutputSettings.setOemClusterHold(app, BydOemClusterHold.COMPONENT)
        assertEquals(BydOemClusterHold.COMPONENT, BydOutputSettings.oemClusterHold(app))
    }

    @Test fun installedStockReceiverDoesNotEnableUnverifiedDilink4Hud() {
        val app = RuntimeEnvironment.getApplication()
        val knownApp = object : ContextWrapper(app) {
            override fun getPackageName(): String = "com.shihab.diplay"
        }
        ShadowBuild.setFingerprint("BYD/DiLink4:10/unverified")
        val info = PackageInfo().apply {
            packageName = "com.byd.clusterdebug"
            applicationInfo = ApplicationInfo().apply {
                packageName = "com.byd.clusterdebug"
                flags = ApplicationInfo.FLAG_SYSTEM
            }
        }
        shadowOf(app.packageManager).installPackage(info)
        assertFalse(BydStandaloneHudOutput.available(knownApp))
        assertTrue(BydStandaloneHudOutput.diagnostics(knownApp).contains("standaloneHudAvailable=false"))
    }

    @Test @Config(sdk = [27])
    @Suppress("DEPRECATION")
    fun androidEightReportsLegacyReceiverMetadataWithoutEnablingUnsupportedHud() {
        val app = RuntimeEnvironment.getApplication()
        val info = PackageInfo().apply {
            packageName = "com.byd.clusterdebug"
            versionCode = 10601004
            applicationInfo = ApplicationInfo().apply {
                packageName = "com.byd.clusterdebug"
                flags = ApplicationInfo.FLAG_SYSTEM
            }
            signatures = arrayOf(Signature(byteArrayOf(1, 2, 3)))
            receivers = arrayOf(ActivityInfo().apply {
                packageName = "com.byd.clusterdebug"
                name = "com.byd.clusterdebug.BroadcastReceiverCAN"
                enabled = true
                exported = true
            })
        }
        // PackageManager needs the owning application when looking up a receiver.
        info.receivers!![0].applicationInfo = info.applicationInfo
        shadowOf(app.packageManager).installPackage(info)

        val report = BydStandaloneHudOutput.diagnostics(app)
        assertFalse(BydStandaloneHudOutput.available(app))
        assertTrue(report.contains("standaloneHudAvailable=false sdk=27"))
        assertTrue(report.contains("version=10601004 system=true"))
        assertTrue(report.contains("receiverEnabled=true exported=true"))
        assertTrue(report.contains("signerSha256="))
        assertFalse(report.contains("receiverMetadataUnavailable"))
    }

}
