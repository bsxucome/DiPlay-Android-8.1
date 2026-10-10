# DiPlay: Android 8.1 compatibility fork

[简体中文 (default)](README.md) · **English** · [Detailed Chinese guide](README.zh-CN.md)

This unofficial fork includes upstream v0.2.17 and retains Android 8.1 (API 27) as its minimum and supported target, with USB and wireless CarPlay. The upstream feature guide below is preserved for context and does not mean this fork's APK has been built or published.

Source version: `0.2.17-android8.1`, version code 36. **The full local CI command, release lint, signed APK build and API 27 emulator upgrade validation passed.** Download the compatibility APK, source archive and checksums from the [v0.2.17 release](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.17-android8.1). Both background and foreground updates use this fork's releases, retaining the original package and release-signing configuration.

All 2,455 unit tests passed without failures or skips, including API 27 regression coverage. The full CI debug builds and lint checks passed. The signed release APK upgraded v0.2.16 on Android 8.1 without changing the UID or first-install timestamp. Home, USB preparation, Settings, Wi-Fi Direct configuration and Simplified Chinese selection opened without a fatal crash or API linkage error. Physical USB/wireless CarPlay still needs vehicle testing. See the [upgrade record](docs/ANDROID8-UPGRADE-0.2.17.zh-CN.md) and [build/compatibility notes](docs/ANDROID8_COMPAT.md).

## Upstream v0.2.17 feature reference

The following feature guide comes from upstream. Its vehicle validation and official release status describe the upstream project. Use the [default README](README.md) and [upgrade record](docs/ANDROID8-UPGRADE-0.2.17.zh-CN.md) for this fork's APK availability, minimum Android version and validation status.

**CarPlay for compatible BYD Android head units.** Wired and wireless, with the familiar DiAuto interface. Independent app: `com.shihab.diplay`.

> **BYD support scope:** These projects focus on BYD cars. They may work on other brands, but other brands are unsupported and there are no plans to add support or fix brand-specific incompatibilities.

[Compatibility APK releases](https://github.com/bsxucome/DiPlay-Android-8.1/releases) · [Upstream website](https://shihabal3amri.github.io/DiPlay/) · [Upstream release](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.17)

![DiPlay home](site/assets/home.png)

## 0.2.17 — public preview

Install on the **car**, not the iPhone. No jailbreak, dongle, Mac, account or authentication server is required for use. Core CarPlay does not require ADB; optional dashboard, battery, wheel-speed and parked-video features do. Your head unit must permit APK installation. Upstream supports Android 7.1+ (API 25); this fork requires Android 8.1+ (API 27), and this version has not yet been confirmed on an Android 8.1 vehicle. Wireless supports Wi-Fi Direct, the car’s existing hotspot or Existing Wi-Fi / Same LAN. Android 7.1–9 Wi-Fi Direct uses a firmware-dependent legacy path with generated group credentials and unverified requested frequency; see [Android 9 Wi-Fi Direct](docs/ANDROID9_WIFI_DIRECT.md). Android 10+ verifies its negotiated group frequency.

- Wired USB and wireless CarPlay with local authentication.
- BYD HUD navigation with arrows, distance and street names on verified firmware.
- Car hotspot support, improved audio buffering and saved receive diagnostics.
- Automatic address discovery, fixed-channel Wi-Fi fallbacks and successful-configuration memory.
- Icon/text size, resolution and frame rate; applying a display change reconnects CarPlay.
- Local diagnostic export. Reports are sent only if you choose to share them.
- Separate installation alongside DiAuto. Run one projection app at a time.

This is **not an Apple-certified product**. The APK bundles an experimental accessory identity recovered from public Carlinkit firmware, not a newly provisioned MFi identity for DiPlay. A bundled private key is extractable. Acceptance after future iOS updates, reliability across head units and suitability of that identity for general distribution are unresolved. This release invites community testing; it is not a guarantee of universal compatibility.

Earlier releases were tested on the development DiLink5.1 car: live windshield guidance and street names work, Car hotspot now starts CarPlay, and Wi-Fi Direct performance is substantially improved. Audio underrun recovery is improved in 0.2.15; remaining cutouts need current diagnostic reports. The 0.2.16 software Opus microphone fallback was accepted on a BOS Mini A1 head unit (Android 9) with an iPhone 12 on iOS 27. The floating-map test build was installed on the development DiLink 5.1 car; feedback led to the pinch corrections in 0.2.9. Earlier wheel-speed and video contributions were tested on a BYD Tang with DiLink 5.0 and an iPhone 15 Pro on iOS 27; wheel-speed dead reckoning in tunnels remains unverified. Broader head-unit and iOS compatibility is not guaranteed. The HUD firmware scope and cleanup limits are documented in [BYD navigation](docs/BYD_NAVIGATION.md).

## What’s new in 0.2.17

- Wired sessions keep running when the head unit delivers a damaged USB network block, instead of reconnecting seconds after the picture appears.
- Older iPhones get a second identification attempt, and USB auto-confirm recognizes the Android 10+ and Chinese permission prompts.
- A new iPhone charging choice under **Settings → Connection → USB connection** for USB ports that cannot supply the iPhone's charging current.
- Voice notes in apps such as WhatsApp record the head unit's microphone and no longer sound slurred.
- Settings recommends the built-in car hotspot; with approved network ADB, the car's Wi-Fi network search pauses during Wi-Fi Direct on Android 7.1 and later.
- A daily update check with an **Update available** notice on Home, which can be turned off in About.
- Album-cover ambient lighting, plus experimental BYD call popup hiding and external controller keys.

See [0.2.17 release notes](docs/RELEASE-NOTES-0.2.17.md) and [validation](docs/VALIDATION.md) for contribution links and remaining physical tests. General stutter, calls/Siri, decoder and model-specific reports still need current-device evidence. [0.2.16 notes](docs/RELEASE-NOTES-0.2.16.md) remain available as historical guidance.

If a problem remains, reproduce it on **0.2.17**, then use **Settings → Diagnostics → Save diagnostic report**. Android 10+ normally saves to **Downloads/DiPlay**; Android 7.1–9 asks for storage access and saves there too. If unavailable, use **View report** or **Share** from the confirmation, which identifies external/private fallback storage. Review the `.txt` and add it to a matching [existing issue](https://github.com/shihabal3amri/DiPlay/issues), or [create one](https://github.com/shihabal3amri/DiPlay/issues/new/choose). Include vehicle/head-unit model, exact firmware and Android/DiLink, phone/iOS, connection backend, relevant settings, steps and failure time. Reports are shared only when you choose; never post your hotspot password.

## Documentation

[Existing Wi-Fi / Same LAN](docs/EXISTING_WIFI.md) keeps the iPhone and head unit
on an external router. See the guide for setup, build requirements and the
BYD DiLink 4.0 / Android 10 clean-install validation result.

- [Install and connect](docs/INSTALL.md)
- [Compatibility and troubleshooting](docs/COMPATIBILITY.md)
- [Smooth wireless CarPlay](docs/SMOOTH_WIRELESS.md)
- [Privacy and diagnostic reports](docs/PRIVACY.md)
- [Build from source](docs/BUILD.md) — select `mobile` for the main DiPlay app; `maphost` is a map sample.
- [Validation](docs/VALIDATION.md)
- [Release notes](CHANGELOG.md)
- [Credits and licenses](docs/THIRD_PARTY_NOTICES.md)

The app and release website are available in English, Arabic, Russian, Ukrainian, Spanish, Simplified Chinese and Traditional Chinese (Taiwan). Traditional Chinese uses Taiwan wording; the app also recognizes Hong Kong/Macao and explicit Hant selections without claiming separate regional translations. Choose the app language in Settings; on Android 13+, it stays synchronized with Android’s per-app language setting.

## Source and credits

Based on [xcertplay](https://github.com/shilapi/xcertplay), GPL-3.0. The home/settings UI and website adapt [DiAuto](https://github.com/shihabal3amri/DiAuto), AGPL-3.0; that license is included in `docs/licenses`. Preserve those notices when distributing modifications. CarPlay and its icon belong to Apple Inc.; no Apple or BYD affiliation or endorsement is implied.

This repository starts with a clean public source snapshot. Local research, tester reports and release-signing secrets are excluded. The complete source corresponding to the APK is provided with every release; experimental runtime identity assets are described separately in the build instructions and notices.

## Local release packaging

The release APK intentionally contains the experimental accessory identity. The Git repository and source archive exclude all accessory and Android signing keys; tests generate synthetic identities at runtime. Source/CI builds omit runtime identity assets by default. Local release builds explicitly select an external asset directory. Publishing the APK makes its bundled identity extractable; building locally does not preserve that identity's confidentiality.
