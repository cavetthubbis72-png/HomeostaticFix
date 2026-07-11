package com.yourname.homeostaticfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import homeostatic.common.temperature.EnvironmentData;
import homeostatic.common.temperature.SubSeason;
import homeostatic.platform.Services;
import net.minecraft.server.level.ServerLevel;

@Mixin(value = EnvironmentData.class, remap = false)
public class RadiationOffsetNullSafeMixin {

    @Inject(method = "radiationOffset", at = @At("HEAD"), cancellable = true)
    private static void onRadiationOffset(double value, ServerLevel level, CallbackInfoReturnable<Double> cir) {
        SubSeason subSeason = Services.PLATFORM.getSubSeason(level);
        if (subSeason == null) {
            cir.setReturnValue(0.0);
        }
    }
}
