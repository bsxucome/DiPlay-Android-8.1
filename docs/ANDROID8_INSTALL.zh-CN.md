# DiPlay v0.2.17 安卓 8.1 适配包

安装文件：`DiPlay-0.2.17-Android8.1.apk`。基于上游 v0.2.17，最低系统为 **Android 8.1（API 27）**，保留 USB 有线与无线 CarPlay。Android 8.0（API 26）无法安装本兼容包。

**新版签名包已发布。** 从 [v0.2.17 发布页](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.17-android8.1)下载 `DiPlay-0.2.17-Android8.1.apk`；发布页同时提供源码压缩包及 SHA-256 校验文件。

## 安装与覆盖升级

在车机上打开 APK 安装，或通过电脑执行：

```sh
adb install -r DiPlay-0.2.17-Android8.1.apk
```

若已安装本仓库发布的 v0.2.13～v0.2.16 安卓 8.1 兼容版，可使用同签名新版覆盖升级并保留应用数据。已在 Android 8.1 模拟器上验证从 v0.2.16 升级：应用 UID 和首次安装时间保持不变。

此包使用独立签名。若车机已安装上游官方签名的 `com.shihab.diplay`，Android 不允许直接覆盖；先备份需要保留的设置，再卸载旧包后安装。

首次使用按提示授予麦克风等权限；USB 连接还需要同意应用的 VPN 请求。有线连接从首页进入“通过 USB 连接”。无线从“设置 → 连接 → 打开连接设置”选择车载热点、Wi-Fi Direct 或现有 Wi-Fi。简体中文可在“设置 → 语言”中选择，默认跟随系统语言。应用内更新只查询本仓库的同签名兼容包。

## 本版更新

合入损坏 USB NCM 数据块恢复、旧 iPhone 识别重试、iPhone 充电声明选项、语音消息麦克风与 Opus 时钟修正、每日更新提醒及专辑封面氛围灯等上游改动。保留旧系统定位、热点地址、媒体回退和诊断适配；Android 12L 专用车辆控制在 Android 8.1 上隐藏。实验性音频、视频与车辆功能请在目标车机上逐项测试。

## 验证与校验

完整 CI 的 **2,455 项单测全部通过，零失败、零跳过**；debug lint、debug 构建、release lint 和签名检查通过。最低 API 27，版本名 `0.2.17-android8.1`，版本代码 36。Android 8.1 模拟器上的首页、USB 准备页、设置、无线配置和中文切换正常，检查期间未见应用崩溃或 API 链接错误。

APK SHA-256：

```text
9d7102887fd139c82fbdffcc819b4999a5ef9c4ad59c95353748bdf5cc0c1e6d
```

模拟器无法验证真实车机和 iPhone 之间的 USB／无线投屏、硬件解码、通话、Siri、方向盘或仪表功能；这些仍需实车测试。如连接失败，请记录车机型号、固件版本、iPhone/iOS 版本及复现步骤，并在“设置 → 诊断”导出报告。

详见[本次升级与验证记录](ANDROID8-UPGRADE-0.2.17.zh-CN.md)和[兼容性与构建说明](ANDROID8_COMPAT.md)。上游许可证和第三方声明仍适用。
