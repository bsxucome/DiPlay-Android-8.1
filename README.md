# DiPlay：Android 8.1 兼容版

[简体中文（默认）](README.md) · [English](README.en.md) · [中文详细说明](README.zh-CN.md)

> 基于[上游 DiPlay v0.2.15](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.15) 的**非官方兼容版**。本仓库 APK 支持 Android 8.1（API 27）及以上系统，保留 USB 有线和无线 CarPlay。上游官方包已声明支持 Android 7.1（API 25）及以上；本仓库的适配与验证以 Android 8.1 为目标。

[下载 Android 8.1 兼容版 APK](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.15-android8.1) · [中文安装说明](docs/ANDROID8_INSTALL.zh-CN.md) · [兼容性说明](docs/ANDROID8_COMPAT.md)

DiPlay 运行在兼容的比亚迪 Android 车机上，接收 iPhone 的 CarPlay 画面和音频，无需越狱、转接盒、Mac 或账号。应用界面支持简体中文和繁体中文，可在“设置 → 语言”中切换。有线与无线核心连接不要求 ADB；部分车辆数据和控制功能需要特定固件及授权的网络 ADB。其他品牌车机不在项目支持范围内。

![DiPlay 首页](site/assets/home.png)

## 安装与升级

1. 在车机上下载并安装上方发布页的 `DiPlay-0.2.15-Android8.1.apk`。最低系统是 **Android 8.1（API 27）**，Android 8.0（API 26）无法安装。
2. 已安装**本仓库** v0.2.13 或 v0.2.14 兼容版的车机，可直接覆盖安装并保留应用数据。本版延续同一包名 `com.shihab.diplay` 和签名；应用内更新检查只查询本仓库的发布。
3. 首次启动按设置向导选择连接方式并授予所需权限。无线可选车机热点、Wi-Fi Direct 或现有 Wi-Fi／同一局域网；有线连接从首页进入 USB 准备页。

若车机安装的是**上游官方签名**的同包名 APK，Android 不允许直接覆盖安装。请先备份需要保留的设置，再卸载旧包并安装本兼容版。发布页提供 `SHA256SUMS.txt`；本版 APK 的 SHA-256 为 `d80bda4208f2a49515a655dd8c3d189b9d0807f71cb22932389dafe50c750bd6`。

## v0.2.15 包含的更新

- 首次启动的 DiLink 设置向导、独立的语言和关于页面，以及“关于”中的更新检查。
- 浅色、深色和自动界面外观；更紧凑的横屏与竖屏布局。
- Wi-Fi Direct 自动 5 GHz／2.4 GHz 选项、音频缓冲恢复和蓝牙重连选项。
- 仪表转向卡片、小窗口导航标记等调整。实验性音视频和车辆功能请在目标车机上逐项测试。

[上游 v0.2.15 完整更新记录](docs/RELEASE-NOTES-0.2.15.md)列出了功能来源与限制。本兼容版仍保留 Android 8.1 所需的旧版 Wi-Fi 接口处理、热点 BSSID 解析、麦克风与视频解码回退等适配。

## 已验证的范围

签名 APK 已在 Android 8.1 模拟器上从本仓库 v0.2.14 覆盖安装；安装记录、原有 Wi-Fi Direct 选择均保留。新版设置向导、首页 USB／无线入口、USB 准备页、连接设置及 5 GHz 选项能够打开。[Linux CI](https://github.com/bsxucome/DiPlay-Android-8.1/actions/runs/37798123829)的完整单测、lint 和 debug 构建已通过。

模拟器无法验证真实车机与 iPhone 的 USB／无线投屏、硬件解码、通话、Siri、仪表或方向盘功能。**Android 8.1 实车兼容性仍需测试，不能保证所有车型都正常运行。** 若遇到问题，请在“设置 → 诊断”导出报告，并提供车机型号、Android／DiLink／固件版本、iPhone／iOS 版本、连接方式和复现步骤。

## 文档与许可

- [中文详细说明](README.zh-CN.md) · [英文说明](README.en.md)
- [Android 8.1 安装指南](docs/ANDROID8_INSTALL.zh-CN.md) · [适配与构建说明](docs/ANDROID8_COMPAT.md) · [源码构建](docs/BUILD.md)
- [隐私与诊断报告](docs/PRIVACY.md) · [第三方许可声明](docs/THIRD_PARTY_NOTICES.md)

本项目基于 [xcertplay](https://github.com/shilapi/xcertplay)（GPL-3.0），界面参考 [DiAuto](https://github.com/shihabal3amri/DiAuto)（AGPL-3.0）。DiPlay 未经 Apple 认证，CarPlay 商标与图标归 Apple 所有。分发修改版本时请遵守仓库中的许可证及第三方声明。
