package com.yourname.homeostaticfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.yourname.homeostaticfix.HomeostaticSeasonFix;

@Mixin(targets = "homeostatic.common.temperature.EnvironmentData")
public abstract class MixinEnvironmentData {

    @Shadow
    private Object subSeason;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        if (this.subSeason == null) {
            try {
                Class<?> seasonClass = Class.forName("sereneseasons.api.season.SubSeason");
                this.subSeason = Enum.valueOf((Class<Enum>) seasonClass, "EARLY_SPRING");
                HomeostaticSeasonFix.LOGGER.warn("Caught null SubSeason, set to EARLY_SPRING via reflection.");
            } catch (Exception e) {
                HomeostaticSeasonFix.LOGGER.error("Failed to set default SubSeason", e);
            }
        }
    }
}
