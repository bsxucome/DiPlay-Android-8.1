package com.shilapi.xcertplay.media

import android.media.MediaCodecInfo
import android.media.MediaCodecList
import android.os.Build

/** Codec capabilities that cannot be inferred from the Android version on a vendor head unit. */
object MediaCodecCompatibility {
    internal fun softwareDecoderName(mime: String): String? = runCatching {
        MediaCodecList(MediaCodecList.REGULAR_CODECS).codecInfos.firstOrNull { codec ->
            !codec.isEncoder && codec.supportedTypes.any { it.equals(mime, ignoreCase = true) } &&
                isSoftwareOnly(codec)
        }?.name
    }.getOrNull()

    private fun isSoftwareOnly(codec: MediaCodecInfo): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) codec.isSoftwareOnly
        else isLegacySoftwareCodec(codec.name)

    // Before API 29 there is no classification API. Only opt in the known AOSP software codecs;
    // treating an unknown vendor codec as software would retry the same failing hardware path.
    internal fun isLegacySoftwareCodec(name: String): Boolean =
        name.startsWith("OMX.google.", ignoreCase = true) ||
            name.startsWith("c2.android.", ignoreCase = true)
}
