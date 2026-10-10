# DiPlay：Android 8.1 兼容版详细说明

[中文首页（默认）](README.md) · **中文详细说明** · [English](README.en.md)

> **非官方兼容版，基于上游 v0.2.17，最低 Android 8.1（API 27）。** 有线与无线 CarPlay、旧系统 Wi-Fi 与媒体适配保留；应用内更新仅查询本兼容版仓库。下文的上游功能介绍不代表本兼容包已构建或发布。

本分支源码已合入 v0.2.17，版本名为 `0.2.17-android8.1`、版本代码为 36。**签名 APK、2,455 项单测、完整 CI、release lint 和 Android 8.1 模拟器覆盖升级验证已完成；GitHub 上传尚未完成。** 当前最新已发布兼容包仍是 [v0.2.16](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.16-android8.1)。实车 USB／无线连接仍需测试。

[本次升级与验证记录](docs/ANDROID8-UPGRADE-0.2.17.zh-CN.md) · [Android 8.1 安装说明](docs/ANDROID8_INSTALL.zh-CN.md)

## 上游 v0.2.17 功能参考

以下介绍来自上游；实车验证记录和官方发布状态属于上游项目。本兼容版的安装包、最低系统和验证进度以[中文首页](README.md)及[本次升级记录](docs/ANDROID8-UPGRADE-0.2.17.zh-CN.md)为准。

为兼容的比亚迪安卓车机提供有线及无线 CarPlay，采用 DiAuto 风格界面。

> 这些项目专注于比亚迪汽车。它们可能在其他品牌上运行，但其他品牌不在支持范围内，也没有增加支持或修复其品牌特定兼容性问题的计划。

[兼容版下载](https://github.com/bsxucome/DiPlay-Android-8.1/releases) · [上游中文网站](https://shihabal3amri.github.io/DiPlay/zh-Hans/) · [上游 0.2.17](https://github.com/shihabal3amri/DiPlay/releases/tag/v0.2.17) · [完整说明](README.md)

## 0.2.17 — 公开预览版

上游官方包最低 Android 7.1（API 25），本兼容版最低 Android 8.1（API 27），请安装在允许 APK 安装的车机上；Android 8.1 尚未经本版实车验证。无需越狱、转接盒、账户或认证服务器。有线及无线核心连接不要求 ADB；可选车辆数据及车辆控制需要支持的固件和已授权网络 ADB。

Wi-Fi Direct 现支持 Android 7.1–9 的旧版建组路径，使用系统返回的真实凭据。首选信道依赖固件 API；Android 7.1–9 无法读回协商频率，所以请求信道在诊断中标为未经验证，系统默认为信道 0。Android 10+ 保留频率验证。也可使用车机内置热点、USB 或[现有 Wi-Fi／同一局域网](docs/EXISTING_WIFI.md)；同一局域网模式由车机和 iPhone 自行连接外部路由器，DiPlay 不替你修改默认路由。[Android 9 Wi-Fi Direct 限制](docs/ANDROID9_WIFI_DIRECT.md)说明清理及持久配置边界。

### 新增与修正

- **有线连接**：车机传来一个损坏的 USB 网络数据块时，会话不再在出现画面后几秒断开重连。旧版 iOS 的 iPhone 会再尝试一次识别；USB 自动确认可识别 Android 10+ 和中文系统的权限提示。
- **iPhone 充电**：新增“**设置 → 连接 → USB 连接 → iPhone 充电**”，适用于供电不足的车机 USB 口，可选降低（1.5 A）或低（0.5 A）。
- **语音消息**：WhatsApp 等应用的语音消息会使用车机麦克风录音，声音不再含糊。
- **Wi-Fi Direct**：设置中推荐使用车机内置热点；在已授权网络 ADB 时，Android 7.1 及以上会在 Wi-Fi Direct 期间暂停车机 Wi-Fi 搜索网络。
- **更新提醒**：每天检查一次新版本，并在主页显示“有可用更新”；可在“关于”中关闭。
- **车辆**：氛围灯可跟随专辑封面；隐藏比亚迪来电弹窗和外接控制器按键为实验性功能。

[0.2.17 完整说明](docs/RELEASE-NOTES-0.2.17.md)包含贡献链接及功能限制；构建和验证信息见[验证记录](docs/VALIDATION.md)。Android 7.1–8.1 尚需实车验证，不宣称所有车型的连接、音频或 Siri 问题均已解决。可选功能请停车后测试。

### 请提供 0.2.17 的新诊断报告

1. 更新到 **0.2.17**，复现问题并记录发生时间。开机／自动启动问题发生后，可手动打开 DiPlay 导出。
2. 打开“**设置 → 诊断 → 保存诊断报告**”。Android 10+ 通常保存到 **Downloads/DiPlay**；Android 7.1–9 会请求存储权限并同样保存到该位置，也可点“选择保存位置”。如选择器或公共存储不可用，应用会使用专用外部或私有目录，并在确认中说明目的地。
3. 使用确认中的**查看报告／分享**；没有分享应用时，可在报告视图中选择并复制文本。检查 `.txt` 并删除隐私信息，再附到匹配的[现有问题](https://github.com/shihabal3amri/DiPlay/issues)，或[新建问题](https://github.com/shihabal3amri/DiPlay/issues/new/choose)。报告不会自动上传，请勿公开热点密码或私有认证文件。
4. 注明车型／车机、DiLink/Android/完整固件版本、iPhone/iOS、USB／车机热点／Wi-Fi Direct／同一局域网、相关设置、复现步骤、预期与实际结果及故障时间。

[从源码构建](docs/BUILD.md)：主应用请选择 `mobile` 模块。`maphost` 是地图演示应用，构建步骤和 APK 路径见说明。

历史记录：[0.2.16](docs/RELEASE-NOTES-0.2.16.md)、[0.2.15](docs/RELEASE-NOTES-0.2.15.md)、[0.2.14](docs/RELEASE-NOTES-0.2.14.md)、[0.2.13](docs/RELEASE-NOTES-0.2.13.md)、[0.2.12](docs/RELEASE-NOTES-0.2.12.md)、[0.2.11](docs/RELEASE-NOTES-0.2.11.md)、[安装与连接](docs/INSTALL.md)。

这是公开预览版，**未经 Apple 认证**。APK 使用从公开 Carlinkit 固件中提取的既有实验性配件身份，并非为 DiPlay 新签发的 MFi 身份；其中的私钥可被提取，未来 iOS 是否继续接受及其公开分发适用性尚未确定。Android 签名密钥和配件身份不进入 Git 或源代码压缩包；普通源代码/CI 构建默认不配置身份。部分车机仍可能卡顿或无法应用图标大小设置。

标准导航小组件需要支持 Android 小组件的启动器；比亚迪内置主页不接受任意小组件。悬浮地图和嵌入地图需要启用“CarPlay 仪表地图”。应用及发布网站支持英语、简体中文、繁体中文（台湾）、阿拉伯语、俄语、乌克兰语和西班牙语。应用的香港／澳门及 Hant 选择使用台湾译文，不宣称提供独立地区翻译。源代码、构建说明及许可证随版本提供。
