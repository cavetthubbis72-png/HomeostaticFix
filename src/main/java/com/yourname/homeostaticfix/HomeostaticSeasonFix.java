package com.yourname.homeostaticfix;

import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("homeostaticfix")
public class HomeostaticSeasonFix {
    public static final Logger LOGGER = LogManager.getLogger("HomeostaticFix");

    public HomeostaticSeasonFix() {
        LOGGER.info("Homeostatic Fix loaded - patching Serene Seasons null safety");
    }
}
