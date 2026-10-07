package com.shilapi.xcertplay.network

import android.content.Context
import android.location.LocationManager
import android.os.Build

/** Diagnostic only: some head units allow Wi-Fi Direct while location is switched off. */
internal object WifiLocationState {
    fun read(context: Context): Boolean? = runCatching {
        val manager = context.getSystemService(LocationManager::class.java) ?: return@runCatching null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            manager.isLocationEnabled
        } else {
            // isLocationEnabled does not exist on Android 8.1.
            manager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        }
    }.getOrNull()
}
