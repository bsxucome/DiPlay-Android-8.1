package com.shilapi.xcertplay.network

import android.content.Context
import android.location.LocationManager
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [27, 28], manifest = Config.NONE)
class WifiLocationStateTest {
    private val context: Context get() = RuntimeEnvironment.getApplication()

    @Test fun disabledLocationIsReportedWithoutCallingAnUnavailableApi() {
        setProviders(gps = false, network = false)
        assertEquals(false, WifiLocationState.read(context))
    }

    @Test fun gpsOnlyLocationIsReported() {
        setProviders(gps = true, network = false)
        assertEquals(true, WifiLocationState.read(context))
    }

    @Test fun networkOnlyLocationIsReported() {
        setProviders(gps = false, network = true)
        assertEquals(true, WifiLocationState.read(context))
    }

    private fun setProviders(gps: Boolean, network: Boolean) {
        val manager = context.getSystemService(LocationManager::class.java)
        shadowOf(manager).setProviderEnabled(LocationManager.GPS_PROVIDER, gps)
        shadowOf(manager).setProviderEnabled(LocationManager.NETWORK_PROVIDER, network)
    }
}
