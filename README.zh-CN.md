# DiPlay

[中文首页（默认）](README.md) · **中文详细说明** · [English](README.en.md)

> **非官方 Android 8.1 兼容版，基于上游 v0.2.16。** 本仓库 APK 最低支持 Android 8.1（API 27）；APK 已在本地构建，[GitHub 发布页待上传](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.16-android8.1) · [安装说明](docs/ANDROID8_INSTALL.zh-CN.md)。本版沿用原有签名，可从本仓库 v0.2.13～v0.2.15 覆盖升级。上游官方包声明支持 Android 7.1+（API 25），但旧车机仍需实测。

为兼容的比亚迪安卓车机提供有线及无线 CarPlay，采用 DiAuto 风格界面。

> 这些项目专注于比亚迪汽车。它们可能在其他品牌上运行，但其他品牌不在支持范围内，也没有增加支持或修复其品牌特定兼容性问题的计划。

[上游中文网站](https://shihabal3amri.github.io/DiPlay/zh-Hans/) · [上游 0.2.16 版本](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.16) · [项目首页](README.md) · [向上游报告问题](https://github.com/shihabal3amri/DiPlay/issues/new/choose)

## 0.2.16 — 公开预览版

本仓库 APK 请安装在允许 APK 安装的 Android 8.1+（API 27+）车机上；Android 8.1 尚未经实车验证。无需越狱、转接盒、账户或认证服务器。有线及无线核心连接不要求 ADB；可选车辆数据及车辆控制需要支持的固件和已授权网络 ADB。

Wi-Fi Direct 在 Android 8.1–9 使用旧版建组路径和系统返回的真实凭据。首选信道依赖固件 API；旧系统无法读回协商频率，所以请求信道在诊断中标为未经验证，系统默认为信道 0。Android 10+ 保留频率验证。也可使用车机内置热点、USB 或[现有 Wi-Fi／同一局域网](docs/EXISTING_WIFI.md)；同一局域网模式由车机和 iPhone 自行连接外部路由器，DiPlay 不替你修改默认路由。[Android 9 Wi-Fi Direct 限制](docs/ANDROID9_WIFI_DIRECT.md)说明清理及持久配置边界。

### 新增与修正

- **Siri 与通话**：在没有系统 Opus 编码器的 Android 8.1–9 车机上，改用内置软件 Opus 编码器发送麦克风声音；上游已在 BOS Mini A1 车机（Android 9）配合 iOS 27 的 iPhone 12 上验证。
- **有线连接**：修复 USB NCM 分帧和 Android 8 读取问题；车机拒绝较大的 USB 读取时，会改用较小的读取重试。
- **无线连接**：首次连接超时后刷新热点地址，支持 Android 17 本地网络权限，VPN 授权界面缺失时不再崩溃，车机热点新增 WPA3 安全选项。
- **视频**：新增实验性“低延迟解码”和“直接视频输出”（默认关闭），“诊断”中新增 FPS 计数器；视频积压恢复改为有界策略，仍需更多实车反馈。
- **设置**：设置页内嵌搜索框；快捷菜单放弃未应用的更改前会先确认；CarPlay 下滑手势可设为关闭。
- **仪表与车辆**：车辆标记位置支持 1% 滑块，小窗口转向卡片可单独设置位置，侧边面板可调整大小，仪表等待画面跟随应用主题。暂停车机蓝牙、音乐氛围灯、导航方向盘音量和 Platform 21 仪表路线均为实验性功能，默认关闭。

[0.2.16 完整说明](docs/RELEASE-NOTES-0.2.16.md)包含贡献链接及功能限制；构建和验证信息见[验证记录](docs/VALIDATION.md)。本兼容版在 Android 8.1 上仍需实车验证，不宣称所有车型的连接、音频或 Siri 问题均已解决。可选功能请停车后测试。

### 请提供 0.2.16 的新诊断报告

1. 更新到 **0.2.16**，复现问题并记录发生时间。开机／自动启动问题发生后，可手动打开 DiPlay 导出。
2. 打开“**设置 → 诊断 → 保存诊断报告**”。Android 10+ 通常保存到 **Downloads/DiPlay**；Android 7.1–9 使用文件选择器，也可点“选择保存位置”。如选择器或公共存储不可用，应用会使用专用外部或私有目录，并在确认中说明目的地。
3. 使用确认中的**查看报告／分享**；没有分享应用时，可在报告视图中选择并复制文本。检查 `.txt` 并删除隐私信息，再附到匹配的[现有问题](https://github.com/shihabal3amri/DiPlay/issues)，或[新建问题](https://github.com/shihabal3amri/DiPlay/issues/new/choose)。报告不会自动上传，请勿公开热点密码或私有认证文件。
4. 注明车型／车机、DiLink/Android/完整固件版本、iPhone/iOS、USB／车机热点／Wi-Fi Direct／同一局域网、相关设置、复现步骤、预期与实际结果及故障时间。

[从源码构建](docs/BUILD.md)：主应用请选择 `mobile` 模块。`maphost` 是地图演示应用，构建步骤和 APK 路径见说明。

历史记录：[0.2.15](docs/RELEASE-NOTES-0.2.15.md)、[0.2.14](docs/RELEASE-NOTES-0.2.14.md)、[0.2.13](docs/RELEASE-NOTES-0.2.13.md)、[0.2.12](docs/RELEASE-NOTES-0.2.12.md)、[0.2.11](docs/RELEASE-NOTES-0.2.11.md)、[安装与连接](docs/INSTALL.md)。

这是公开预览版，**未经 Apple 认证**。APK 使用从公开 Carlinkit 固件中提取的既有实验性配件身份，并非为 DiPlay 新签发的 MFi 身份；其中的私钥可被提取，未来 iOS 是否继续接受及其公开分发适用性尚未确定。Android 签名密钥和配件身份不进入 Git 或源代码压缩包；普通源代码/CI 构建默认不配置身份。部分车机仍可能卡顿或无法应用图标大小设置。

标准导航小组件需要支持 Android 小组件的启动器；比亚迪内置主页不接受任意小组件。悬浮地图和嵌入地图需要启用“CarPlay 仪表地图”。应用及发布网站支持英语、简体中文、繁体中文（台湾）、阿拉伯语、俄语、乌克兰语和西班牙语。应用的香港／澳门及 Hant 选择使用台湾译文，不宣称提供独立地区翻译。源代码、构建说明及许可证随版本提供。
