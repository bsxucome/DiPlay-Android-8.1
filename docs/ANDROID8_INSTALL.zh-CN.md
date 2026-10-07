# DiPlay v0.2.13 安卓 8.1 适配包

安装文件：`DiPlay-0.2.13-Android8.1.apk`。基于上游 v0.2.13 修改，最低系统为 Android 8.1（API 27），保留 USB 有线与无线 CarPlay。Android 8.0（API 26）不在本次适配范围内。

在车机上打开 APK 安装，或通过电脑执行 `adb install DiPlay-0.2.13-Android8.1.apk`。首次使用按提示授予麦克风等权限；USB 连接还需要同意应用的 VPN 请求。在应用“设置 → 连接设置”中选择车载热点、Wi‑Fi Direct 或现有 Wi‑Fi；有线连接可从首页“Connect with USB”进入。

此包使用独立签名。若车机已经安装官方签名的 `com.shihab.diplay`，Android 不允许直接覆盖安装；先备份需要保留的设置，再卸载旧包后安装。

验证结果：官方 v0.2.13 包在 Android 8.1 模拟器报 `INSTALL_FAILED_OLDER_SDK`；适配包在同一模拟器安装成功，首页、设置、USB 准备页和 Wi‑Fi Direct 设置能正常打开。APK 签名校验及静态检查通过，本次新增的 Android 8.1 相关测试通过。全量测试中有 6 个未修改的 Android 13 热点事务／Windows shell 测试失败，不涉及上述适配路径。

模拟器无法验证真实车机和 iPhone 之间的 USB／无线投屏、硬件解码、通话音频及方向盘或仪表功能。因此“完美运行”仍需在目标车机上实测；不同车机固件会影响兼容性。如连接失败，请记录车机型号、固件版本、iPhone/iOS 版本，并在应用设置中导出诊断报告。

源码及改动说明见 `DiPlay/` 与 `DiPlay/docs/ANDROID8_COMPAT.md`。上游许可证和第三方声明仍适用。
