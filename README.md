[中文](./README_zh-CN.md) | English
# HomeostaticFix
Homeostatic Cross-Dimension Crash Fix

Overview

This patch fixes a crash caused by Homeostatic mod when crossing dimensions with Serene Seasons installed. The crash occurs due to missing season data (subSeason) in custom dimensions, leading to a NullPointerException.

Affected Scenarios

You may encounter the following crash when entering custom dimensions (e.g., Aether, Twilight Forest, Eternal Starlight) with both mods active:

```
java.lang.NullPointerException: Cannot invoke "homeostatic.common.temperature.SubSeason.ordinal()" because "subSeason" is null
```

This patch prevents the crash by intercepting the null season data during EnvironmentData initialization and setting a safe default value (EARLY_SPRING) instead of letting the game fail.

How to Use

1. Ensure you have the following mods installed:
   · Homeostatic (any 1.21.1 version)
   · Serene Seasons (any 1.21.1 version)
   · NeoForge 21.1.x
2. Place this .jar file into your .minecraft/mods/ folder.
3. Launch the game.

Compatibility

· Works with most custom dimension mods (Aether, Twilight Forest, Eternal Starlight, etc.)
· Does not affect season behavior in the Overworld or other dimensions
· No configuration required

Known Limitations

· This patch only addresses the null season crash; it does not modify any other Homeostatic behavior
· If the official mod updates to fix this issue in the future, this patch may become redundant

Disclaimer

This patch is a community-made workaround, not an official release. Use it at your own discretion. Feedback is welcome, but no guarantee is provided for all environments.
