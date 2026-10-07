package com.shilapi.xcertplay.network

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class HotspotBssidTest {
    @Test fun configurationBssidDecodesAllSixUnsignedOctets() {
        assertArrayEquals(
            byteArrayOf(0x02, 0x1a, 0x7f, 0x80.toByte(), 0xcd.toByte(), 0xff.toByte()),
            parseHotspotBssid("02:1A:7f:80:cD:ff"),
        )
    }

    @Test fun malformedConfigurationCannotSelectAnUnrelatedApInterface() {
        listOf("", "02:1a:7f:80:cd", "02:1a:7f:80:cd:ff:01", "02:1a:7f:80:cd:gg",
            "02-1a-7f-80-cd-ff", "02:1a:7f:80:cd:100", " 02:1a:7f:80:cd:ff").forEach {
            assertThrows(IllegalArgumentException::class.java) { parseHotspotBssid(it) }
        }
    }
}
