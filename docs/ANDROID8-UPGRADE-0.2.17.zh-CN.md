# v0.2.17 安卓 8.1 升级记录

上游标签：`v0.2.17`，提交 `391c90f80b4d54b2732dbbb3e51bf56910768ceb`。兼容分支从已发布的 v0.2.16 升级，验证日期为 2026-10-10。

**本地签名 APK 和验证已完成，源码及附件已同步到 GitHub。** 最新兼容包见 [v0.2.17 发布页](https://github.com/bsxucome/DiPlay-Android-8.1/releases/tag/v0.2.17-android8.1)。

## 适配范围

- `mobile`、`common`、`shared` 最低系统仍为 API 27；native 的 `APP_PLATFORM` 仍为 `android-27`。
- 版本名为 `0.2.17-android8.1`，版本代码为 36（前版为 35），沿用原包名 `com.shihab.diplay` 和签名。
- USB 有线、车机热点、Wi-Fi Direct 和现有 Wi-Fi 保留；旧系统的定位检查、BSSID 解析、签名诊断及视频解码回退保留。
- 前台和新增后台更新共用兼容版仓库查询地址，避免提供上游的不同签名 APK。
- Android 8.1/9 诊断导出申请旧版存储权限；拒绝时仍保留可查看和分享的报告。旧系统更新 APK 使用应用专用外部目录，不调用 Android 10 才加入的 MediaStore Downloads API。
- Android 12L 专用的比亚迪通话弹窗控制在 API 27 上隐藏。
- README 默认中文，另提供英文和中文详细说明；上游文档副本已同步。

## 完整检查结果

使用 JDK 25、Gradle 9.5.0、Android SDK 37 和 NDK 28.2.13676358，执行仓库 `AGENTS.md` 规定的全部 CI 任务。

| 检查 | 结果 |
| --- | --- |
| `shared` 单测 | 1,325 项通过 |
| `common` 单测 | 1,126 项通过 |
| `home` 单测 | 4 项通过 |
| 单测总计 | **2,455 项，零失败、零跳过** |
| `mobile`、`home`、`maphost` debug lint 与 APK 构建 | 通过 |
| `mobile:lintRelease` 与签名 release 构建 | 通过 |
| APK 最低系统、版本与签名校验 | API 27、版本代码 36，与 v0.2.16 同签名 |
| 运行时认证资产 | 与本地选定输入一致；APK 不含 Android 签名密钥库 |
| 公开树与空白检查 | 通过；私有认证资产和签名密钥未加入源码 |

已扩展 API 27 回归用例：USB NCM 损坏块恢复、充电选项保存、Wi-Fi 自动搜索开关、诊断导出、更新 APK 导出、新版提示缓存、USB 权限、VPN 授权和隐藏不支持的车辆控制。

首次构建曾受网络权限限制。权限恢复后，下载了新增 WorkManager 和缺失的测试依赖，使用本机缓存的同版本 Gradle 运行完整检查。Windows 测试夹具通过 stdin 执行 shell，保留嵌套引号；热点恢复用例使用测试专用的原子替换实现来匹配 Android 的文件重命名语义。相关断言保留，生产存储逻辑未修改。上游界面用例的最低 SDK 调整为本分支实际支持的 API 27。此次 JavaCompile 正常运行，未跳过编译任务。

## Android 8.1 模拟器验证

- 在 API 27 模拟器上以 `adb install -r` 覆盖本仓库 v0.2.16 成功。
- 应用 UID 保持 `10059`；首次安装时间保持 `2026-10-07 10:25:18`。
- 首页、USB 准备页、设置、Wi-Fi Direct 配置页正常打开。
- 切换为简体中文后，设置与连接页面正确显示中文；停止应用并重新启动后语言仍保留。
- 检查期间日志未发现 `FATAL EXCEPTION`、`VerifyError`、`NoSuchMethodError` 或 `NoClassDefFoundError`。

## 安装包

文件：`DiPlay-0.2.17-Android8.1.apk`，17,717,220 字节。

SHA-256：

```text
9d7102887fd139c82fbdffcc819b4999a5ef9c4ad59c95353748bdf5cc0c1e6d
```

签名证书 SHA-256：

```text
a3d45e335e1fed4343f945df36adc477c339f09109c451ed701503cce3d75484
```

## 仍需完成

源码已同步到个人仓库主分支；发布附件包括已验证标签对应的源码压缩包、签名 APK 和校验文件。GitHub 自动检查结果见[仓库 Actions](https://github.com/bsxucome/DiPlay-Android-8.1/actions)。

USB／无线连接、语音消息、通话、Siri、硬件视频和比亚迪车辆功能仍需实际车机与 iPhone 验证。模拟器安装和单测通过不能证明所有车机均可完美运行。
