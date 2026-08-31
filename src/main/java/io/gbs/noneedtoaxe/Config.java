package io.gbs.noneedtoaxe;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean healingAxe = true;
    public static boolean totemOfUndying = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        healingAxe = configuration.getBoolean(
            "healing_axe",
            Configuration.CATEGORY_GENERAL,
            healingAxe,
            "True to enable hiding the healing axe in the offhand.");
        totemOfUndying = configuration.getBoolean(
            "totem_of_undying",
            Configuration.CATEGORY_GENERAL,
            totemOfUndying,
            "True to enable hiding the totem of undying in the offhand.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
