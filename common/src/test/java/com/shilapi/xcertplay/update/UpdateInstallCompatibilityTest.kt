package com.shilapi.xcertplay.update

import android.provider.Settings
import com.shilapi.xcertplay.DiPlayActivity
import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [27, 28, 33])
class UpdateInstallCompatibilityTest {
    @Test fun installationUsesOnlySupportedPermissionApis() {
        val activity = Robolectric.buildActivity(DiPlayActivity::class.java).get()
        val apk = File(activity.cacheDir, "update/test/DiPlay.apk").apply {
            parentFile!!.mkdirs()
            writeBytes(byteArrayOf(1))
        }
        DiPlayActivity::class.java.getDeclaredField("updateFile")
            .apply { isAccessible = true }.set(activity, apk)
        DiPlayActivity::class.java.getDeclaredMethod("installUpdate")
            .apply { isAccessible = true }.invoke(activity)
        val intent = shadowOf(activity).nextStartedActivity
        assertEquals(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, intent.action)
    }
}
