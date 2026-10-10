# Android 8.1 compatibility build

## Current source: v0.2.17

This branch now includes upstream `v0.2.17` (`391c90f80b4d54b2732dbbb3e51bf56910768ceb`). The mobile version is `0.2.17-android8.1`, version code 36. The API 27 minimum, native target, package name, signing configuration, earlier Android 8 fixes and fork-only updater are retained. Both foreground and new background update checks share the fork's release lookup.

The full required CI command passed with Gradle 9.5.0 and JDK 25: 1,325 shared tests, 1,126 common tests and 4 Home tests, with zero failures and zero skips. Debug lint and builds passed for mobile, home and maphost. The release lint and signed APK build also passed; JavaCompile ran normally without disabling compilation tasks.

API 27 coverage was added or extended for USB NCM recovery, charging settings, the legacy Wi-Fi autojoin switch, diagnostics, update APK export, update-banner persistence and hiding the Android 12L-only call-popup control. Storage permissions apply to Android 8.1/9; newer-only APIs and firmware options stay gated.

The signed APK has minimum API 27, version code 36 and the same certificate as v0.2.16. Its runtime authentication assets match the selected local inputs, and the Android signing keystore is absent from the APK. On an API 27 emulator it upgraded v0.2.16 while preserving the UID and first-install timestamp. Home, USB preparation, Settings, Wi-Fi Direct configuration, Chinese selection and a subsequent cold launch worked without a fatal crash or API linkage error during the checks.

**The v0.2.17 APK, validated source archive and checksums are available from the [GitHub release](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.17-android8.1).** Physical USB/wireless CarPlay, calls, Siri, head-unit codecs and vehicle controls need testing on the target car and iPhone. See [the upgrade record](ANDROID8-UPGRADE-0.2.17.zh-CN.md).

## Previously validated release: v0.2.16

This branch includes the upstream `v0.2.16` release. Upstream declares Android 7.1 (API 25) as its minimum; this fork retains Android 8.1 (API 27) as its supported target in the mobile, common, shared and native builds. Android 8.0 (API 26) is outside this fork's scope. Both USB and wireless CarPlay remain available.

The API 27 fixes include the legacy Wi-Fi Direct location preflight, local-only hotspot BSSID parsing, package signature diagnostics and a software video decoder fallback on older Android versions. Upstream v0.2.16 adds a software Opus encoder for older systems without a working platform encoder; when neither encoder is available, the receiver offers PCM microphone input. Features that require newer Android or specific BYD firmware remain conditional.

The v0.2.16 Android 8 USB read and NCM framing fixes, wireless hotspot address recovery, software Opus fallback, embedded Settings search and video diagnostics are included. Experimental audio and video paths remain opt-in and require head-unit testing. An existing installation of this fork's v0.2.13–v0.2.15 Android 8.1 APK can update in place because the package name and signing certificate are unchanged and the version code increases from 34 to 35 after v0.2.15. The in-app updater checks this fork's releases so it does not offer an upstream APK signed with a different certificate.

Build requirements are listed in [BUILD.md](BUILD.md). A standalone APK also needs the two runtime authentication files described there. The public upstream source archive does not include those files. When using the upstream release APK as the source of the files, verify its SHA-256 against the official `SHA256SUMS.txt` before extracting `assets/offline-mfi/identity.pk8` and `assets/offline-mfi/certificate.p7b` to an external, untracked `DIPLAY_AUTH_ASSETS_DIR`. Keep the Android signing key external as well. This fork uses a different signing certificate, so Android cannot install it as an in-place update over an upstream-signed APK.

The signed v0.2.16 APK passed release lint and installed over this fork's v0.2.15 APK on an API 27 emulator. The package UID and first-install timestamp were preserved. The home screen, USB preparation, Settings and Wi-Fi Direct configuration opened without an app crash. All 54 focused tests for Opus, AirPlay microphone formats, hotspot address recovery and USB/NCM framing policy passed. The full local test command could not finish because Robolectric needed an uncached Android image while network access was unavailable. This Windows sandbox also prevented Gradle's JavaCompile from closing JAR files, so the bundled Concentus Java sources were compiled locally for Java 11 before the signed release build; a normal clean CI build remains necessary when GitHub access is restored. An emulator cannot establish real USB or wireless CarPlay with an iPhone or verify head-unit codec, radio, audio and vehicle-firmware behavior. Those paths require a test on the target car and phone before claiming they work reliably. Export a diagnostic report from Settings if a connection fails.

The upstream license and notices still apply to modified builds; see [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md) and the repository licenses.
