## Homeostatic 跨维度崩溃修复补丁

### 概述

本补丁修复了 **Homeostatic（稳态/体温模组）** 与 **Serene Seasons（静谧四季）** 在跨维度传送时因季节数据缺失而导致的游戏崩溃问题。

### 适用场景

当您安装以下模组组合并尝试进入自定义维度（如天境、暮色森林、永恒星光等）时，可能会遇到类似崩溃：

java.lang.NullPointerException: Cannot invoke "homeostatic.common.temperature.SubSeason.ordinal()" because "subSeason" is null


本补丁通过在 `EnvironmentData` 初始化时拦截空季节数据并设置安全默认值（早春），有效避免了该崩溃。

### 使用方法

1. 确保已安装以下模组（均为 1.21.1 版本）：
   - Homeostatic
   - Serene Seasons
   - NeoForge 21.1.x
2. 将本补丁的 `.jar` 文件放入 `.minecraft/mods/` 文件夹。
3. 启动游戏即可。

### 兼容性

- 支持大部分自定义维度模组（Aether、Twilight Forest、Eternal Starlight 等）
- 不影响主世界及其他维度的正常季节表现
- 无需额外配置

### 已知问题

- 此补丁仅针对季节数据空指针异常，不涉及 Homeostatic 其他功能调整
- 若官方后续版本修复此问题，本补丁可能不再需要

### 说明

本补丁为社区临时修复方案，非官方出品。如有问题欢迎反馈，但不保证在所有环境均能正常工作。
