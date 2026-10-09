# DiPlay：Android 8.1 兼容版

[简体中文（默认）](README.md) · [English](README.en.md) · [中文详细说明](README.zh-CN.md)

> 基于[上游 DiPlay v0.2.16](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.16) 的**非官方兼容版**。本仓库 APK 支持 Android 8.1（API 27）及以上系统，保留 USB 有线和无线 CarPlay。上游官方包已声明支持 Android 7.1（API 25）及以上；本仓库的适配与验证以 Android 8.1 为目标。

v0.2.16 APK 已在本地构建，[GitHub 发布页待上传](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.16-android8.1)。[中文安装说明](docs/ANDROID8_INSTALL.zh-CN.md) · [兼容性说明](docs/ANDROID8_COMPAT.md)

DiPlay 运行在兼容的比亚迪 Android 车机上，接收 iPhone 的 CarPlay 画面和音频，无需越狱、转接盒、Mac 或账号。应用界面支持简体中文和繁体中文，可在“设置 → 语言”中切换。有线与无线核心连接不要求 ADB；部分车辆数据和控制功能需要特定固件及授权的网络 ADB。其他品牌车机不在项目支持范围内。

![DiPlay 首页](site/assets/home.png)

## 安装与升级

1. 获取并安装 `DiPlay-0.2.16-Android8.1.apk`。GitHub 发布页上传完成前，可使用本地工作区生成的同名文件。最低系统是 **Android 8.1（API 27）**，Android 8.0（API 26）无法安装。
2. 已安装**本仓库** v0.2.13～v0.2.15 兼容版的车机，可直接覆盖安装并保留应用数据。本版延续同一包名 `com.shihab.diplay` 和签名；应用内更新检查只查询本仓库的发布。
3. 首次启动按设置向导选择连接方式并授予所需权限。无线可选车机热点、Wi-Fi Direct 或现有 Wi-Fi／同一局域网；有线连接从首页进入 USB 准备页。

若车机安装的是**上游官方签名**的同包名 APK，Android 不允许直接覆盖安装。请先备份需要保留的设置，再卸载旧包并安装本兼容版。发布页同时提供 APK 和 `SHA256SUMS.txt` 校验文件。

## v0.2.16 包含的更新

- 对没有系统 Opus 编码器的旧车机，增加软件 Opus 麦克风回退，改善无线通话和 Siri。
- 修复 USB NCM 分帧与 Android 8 读取，较大读取被拒绝时自动缩小重试；无线连接超时后刷新热点地址。
- 新增设置页内嵌搜索、视频 FPS 诊断和更细的仪表布局控制。
- 低延迟解码、直接视频输出及若干车辆功能为实验性选项，请在目标车机上逐项测试。

[上游 v0.2.16 完整更新记录](docs/RELEASE-NOTES-0.2.16.md)列出了功能来源与限制。本兼容版仍保留 Android 8.1 所需的旧版 Wi-Fi 接口处理、热点 BSSID 解析及视频解码回退等适配。

## 已验证的范围

v0.2.16 签名 APK 已通过 release lint，并在 Android 8.1（API 27）模拟器上从本仓库 v0.2.15 覆盖升级；应用 UID、首次安装时间保持不变。首页、USB 准备页、设置和 Wi-Fi Direct 配置页均可打开，近期日志未见应用崩溃。完整单测受本机离线 Robolectric 镜像缺失影响，仍需在联网环境运行；真实车机也需实测。

模拟器无法验证真实车机与 iPhone 的 USB／无线投屏、硬件解码、通话、Siri、仪表或方向盘功能。**Android 8.1 实车兼容性仍需测试，不能保证所有车型都正常运行。** 若遇到问题，请在“设置 → 诊断”导出报告，并提供车机型号、Android／DiLink／固件版本、iPhone／iOS 版本、连接方式和复现步骤。

## 文档与许可

- [中文详细说明](README.zh-CN.md) · [英文说明](README.en.md)
- [Android 8.1 安装指南](docs/ANDROID8_INSTALL.zh-CN.md) · [适配与构建说明](docs/ANDROID8_COMPAT.md) · [源码构建](docs/BUILD.md)
- [隐私与诊断报告](docs/PRIVACY.md) · [第三方许可声明](docs/THIRD_PARTY_NOTICES.md)

本项目基于 [xcertplay](https://github.com/shilapi/xcertplay)（GPL-3.0），界面参考 [DiAuto](https://github.com/shihabal3amri/DiAuto)（AGPL-3.0）。DiPlay 未经 Apple 认证，CarPlay 商标与图标归 Apple 所有。分发修改版本时请遵守仓库中的许可证及第三方声明。
