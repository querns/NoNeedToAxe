package io.gbs.noneedtoaxe;

import static io.gbs.noneedtoaxe.NoNeedToAxe.LOG;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.rwtema.extrautils.ExtraUtils;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import ganymedes01.etfuturum.ModItems;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {

    @Override
    public void postInit(final FMLPostInitializationEvent event) {
        super.postInit(event);
        LOG.info("Attaching special renderers.");

        if (Loader.isModLoaded(Constants.BACKHAND)) {
            // The healing axe requires a mixin to hook into the default XU renderer, so the actual config checks are
            // being done in the mixin registration. This line is just to print some stuff to the log so the user has
            // some clues about the config in the event that they're trying to get the healing axe render blocking to
            // work and it isn't.
            isEnabled(Constants.EXTRA_UTILITIES, Config.healingAxe, ExtraUtils.healingAxe);

            if (isEnabled(Constants.ET_FUTURUM_REQUIEM, Config.totemOfUndying, ModItems.TOTEM_OF_UNDYING.get())) {
                MinecraftForgeClient.registerItemRenderer(ModItems.TOTEM_OF_UNDYING.get(), SubstituteRenderer.INSTANCE);
            }
        } else {
            LOG.info("Did not attach any renderers because Backhand was not loaded.");
        }
    }

    private static boolean isEnabled(final String modID, final boolean configValue, final Item item) {
        final String unlocalizedName = item.getUnlocalizedName();

        if (!Loader.isModLoaded(modID)) {
            LOG.info("Did not attach renderer for {}, mod {} was not found.", unlocalizedName, modID);
        } else if (!configValue) {
            LOG.info("Did not attach renderer for {}, it was disabled in the configuration.", unlocalizedName);
        } else {
            LOG.info("Successfully attached blocking renderer to {}.", unlocalizedName);
            return true;
        }

        return false;
    }
}
