# DiPlay：Android 8.1 兼容版

[简体中文（默认）](README.md) · [English](README.en.md) · [中文详细说明](README.zh-CN.md)

> 基于[上游 DiPlay v0.2.17](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.17) 的**非官方兼容版**。本仓库 APK 支持 Android 8.1（API 27）及以上系统，保留 USB 有线和无线 CarPlay。上游官方包已声明支持 Android 7.1（API 25）及以上；本仓库的适配与验证以 Android 8.1 为目标。

本分支源码已合入 v0.2.17，版本名为 `0.2.17-android8.1`、版本代码为 36。**v0.2.17 APK 构建、完整验证及发布尚未完成。** 当前最新已发布兼容包仍是 [v0.2.16](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.16-android8.1)。 [中文安装说明](docs/ANDROID8_INSTALL.zh-CN.md) · [兼容性说明](docs/ANDROID8_COMPAT.md)

DiPlay 运行在兼容的比亚迪 Android 车机上，接收 iPhone 的 CarPlay 画面和音频，无需越狱、转接盒、Mac 或账号。应用界面支持简体中文和繁体中文，可在“设置 → 语言”中切换。有线与无线核心连接不要求 ADB；部分车辆数据和控制功能需要特定固件及授权的网络 ADB。其他品牌车机不在项目支持范围内。

![DiPlay 首页](site/assets/home.png)

## 安装与升级

1. 从 [GitHub 发布页](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.16-android8.1)下载并安装 `DiPlay-0.2.16-Android8.1.apk`。最低系统是 **Android 8.1（API 27）**，Android 8.0（API 26）无法安装。
2. v0.2.17 延续原签名配置并递增版本代码；待签名构建和覆盖升级验证完成后，可从**本仓库** v0.2.13～v0.2.16 兼容版升级。本版延续同一包名 `com.shihab.diplay` 和签名；应用内更新检查只查询本仓库的发布。
3. 首次启动按设置向导选择连接方式并授予所需权限。无线可选车机热点、Wi-Fi Direct 或现有 Wi-Fi／同一局域网；有线连接从首页进入 USB 准备页。

若车机安装的是**上游官方签名**的同包名 APK，Android 不允许直接覆盖安装。请先备份需要保留的设置，再卸载旧包并安装本兼容版。发布页同时提供 APK 和 `SHA256SUMS.txt` 校验文件。

## v0.2.17 包含的更新

- USB 收到单个损坏的 NCM 数据块时尝试恢复，不立即断开整个会话；接口占用时重试，旧 iPhone 的识别可移除不支持的消息后重试一次。
- 新增“设置 → 连接 → USB 连接 → iPhone 充电”选项：正常 2.4 A、降低 1.5 A、低 0.5 A。下次 USB 连接生效；这是向 iPhone 声明的电流，并非车机端硬件限流。
- 应用语音消息可使用车机麦克风，并修正 16 kHz Opus RTP 时钟；保留旧车机的软件 Opus 与 PCM 回退。
- 优先推荐车机内置热点。Wi-Fi Direct 在已有网络 ADB 授权时可暂停自动网络搜索，结束后恢复；没有授权时仍可使用核心连接。
- 每天通过有互联网的网络检查新版，在首页提示；前台和后台更新均只查询本兼容版仓库，不自动下载或安装。
- Android 8.1/9 诊断报告获得存储授权后可保存到 `Downloads/DiPlay`，拒绝时回退到应用目录。增加专辑封面氛围灯和外接控制器支持。

Android 12L 专用的比亚迪通话弹窗控制在 Android 8.1 上隐藏。实验性车辆、音频和视频功能仍需在目标车机上逐项测试。

[上游 v0.2.17 完整更新记录](docs/RELEASE-NOTES-0.2.17.md)列出了功能来源与限制。本兼容版保留 API 27 的定位检查、热点 BSSID 解析、签名诊断和旧系统视频解码回退。

## 已验证的范围

v0.2.17 已通过 45 项重点 JVM 逻辑测试，包括语音消息麦克风策略、Opus 时间戳、RTP 时钟探测、Wi-Fi 扫描暂停恢复、旧 iPhone 识别重试及版本比较。已新增或扩展 API 27 回归用例。完整 CI、release lint、签名 APK 构建和模拟器覆盖升级受当前本机网络及 Gradle 服务连接限制，**尚未通过**。详见[本次升级记录](docs/ANDROID8-UPGRADE-0.2.17.zh-CN.md)。v0.2.16 的验证结果不能代替本版验证。

模拟器无法验证真实车机与 iPhone 的 USB／无线投屏、硬件解码、通话、Siri、仪表或方向盘功能。**Android 8.1 实车兼容性仍需测试，不能保证所有车型都正常运行。** 若遇到问题，请在“设置 → 诊断”导出报告，并提供车机型号、Android／DiLink／固件版本、iPhone／iOS 版本、连接方式和复现步骤。

## 文档与许可

- [中文详细说明](README.zh-CN.md) · [英文说明](README.en.md)
- [Android 8.1 安装指南](docs/ANDROID8_INSTALL.zh-CN.md) · [适配与构建说明](docs/ANDROID8_COMPAT.md) · [源码构建](docs/BUILD.md)
- [隐私与诊断报告](docs/PRIVACY.md) · [第三方许可声明](docs/THIRD_PARTY_NOTICES.md)

本项目基于 [xcertplay](https://github.com/shilapi/xcertplay)（GPL-3.0），界面参考 [DiAuto](https://github.com/shihabal3amri/DiAuto)（AGPL-3.0）。DiPlay 未经 Apple 认证，CarPlay 商标与图标归 Apple 所有。分发修改版本时请遵守仓库中的许可证及第三方声明。
