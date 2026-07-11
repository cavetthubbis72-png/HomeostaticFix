package com.cavetthubbis72.homeostaticfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import homeostatic.common.temperature.SubSeason;
import homeostatic.util.SereneSeasonsForgeHelper;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.SeasonHelper;

@Mixin(value = SereneSeasonsForgeHelper.class, remap = false)
public class SereneSeasonsNullSafeMixin {

    @Inject(method = "getSubSeason", at = @At("HEAD"), cancellable = true)
    private static void onGetSubSeason(Level level, CallbackInfoReturnable<SubSeason> cir) {
        if (SeasonHelper.getSeasonState(level) == null) {
            cir.setReturnValue(SubSeason.EARLY_SPRING);
        }
    }

    @Inject(method = "getSeasonDuration", at = @At("HEAD"), cancellable = true)
    private static void onGetSeasonDuration(Level level, CallbackInfoReturnable<Integer> cir) {
        if (SeasonHelper.getSeasonState(level) == null) {
            cir.setReturnValue(72000);
        }
    }
}
