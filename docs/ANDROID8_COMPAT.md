# Android 8.1 compatibility build

This branch starts from the upstream `v0.2.13` release. It lowers the mobile, common, shared and native minimum platform to Android 8.1 (API 27). Android 8.0 (API 26) is not covered. Both USB and wireless CarPlay are retained.

The API 27 fixes include the legacy Wi-Fi Direct location preflight, local-only hotspot BSSID parsing, package signature diagnostics, a PCM microphone offer when no Opus encoder exists, and a software video decoder fallback on older Android versions. Features that require newer Android or specific BYD firmware remain conditional.

Build requirements are listed in [BUILD.md](BUILD.md). A standalone APK also needs the two runtime authentication files described there. The public upstream source archive does not include those files. When using the upstream release APK as the source of the files, verify its SHA-256 against the official `SHA256SUMS.txt` before extracting `assets/offline-mfi/identity.pk8` and `assets/offline-mfi/certificate.p7b` to an external, untracked `DIPLAY_AUTH_ASSETS_DIR`. Keep the Android signing key external as well. This fork uses a different signing certificate, so Android cannot install it as an in-place update over an upstream-signed APK.

The v0.2.13 APK refuses installation on API 27 (`INSTALL_FAILED_OLDER_SDK`). The compatibility APK can be checked with `aapt dump badging`, installed with `adb install`, and launched on an API 27 emulator. An emulator cannot establish real USB or wireless CarPlay with an iPhone or verify head-unit codec, radio, audio and vehicle-firmware behavior. Those paths require a test on the target car and phone before claiming they work reliably. Export a diagnostic report from Settings if a connection fails.

The upstream license and notices still apply to modified builds; see [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md) and the repository licenses.
