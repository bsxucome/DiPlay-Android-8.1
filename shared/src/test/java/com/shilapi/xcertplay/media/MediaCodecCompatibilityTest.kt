package com.shilapi.xcertplay.media

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MediaCodecCompatibilityTest {
    @Test fun oldAndroidCanRecognizeItsAospSoftwareDecoders() {
        assertTrue(MediaCodecCompatibility.isLegacySoftwareCodec("OMX.google.h264.decoder"))
        assertTrue(MediaCodecCompatibility.isLegacySoftwareCodec("OMX.google.hevc.decoder"))
        assertTrue(MediaCodecCompatibility.isLegacySoftwareCodec("c2.android.avc.decoder"))
        assertTrue(MediaCodecCompatibility.isLegacySoftwareCodec("omx.GOOGLE.h264.decoder"))
    }

    @Test fun vendorOrUnknownDecodersAreNotTreatedAsSoftwareFallbacks() {
        for (name in listOf("OMX.MTK.VIDEO.DECODER.AVC", "OMX.qcom.video.decoder.avc",
            "c2.mtk.avc.decoder", "OMX.googleish.decoder", "", "unknown")) {
            assertFalse(name, MediaCodecCompatibility.isLegacySoftwareCodec(name))
        }
    }
}
