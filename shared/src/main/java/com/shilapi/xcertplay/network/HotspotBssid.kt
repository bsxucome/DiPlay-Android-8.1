package com.shilapi.xcertplay.network

/** Decodes WifiConfiguration.BSSID without depending on the API 28 MacAddress class. */
internal fun parseHotspotBssid(value: String): ByteArray {
    require(Regex("[0-9a-fA-F]{2}(:[0-9a-fA-F]{2}){5}").matches(value)) {
        "BSSID must contain six hexadecimal octets"
    }
    return value.split(':').map { it.toInt(16).toByte() }.toByteArray()
}
