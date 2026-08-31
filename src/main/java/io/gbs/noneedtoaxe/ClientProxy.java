package io.gbs.noneedtoaxe;

import static io.gbs.noneedtoaxe.NoNeedToAxe.LOG;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.rwtema.extrautils.item.ItemHealingAxe;

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
            attachRenderer(Constants.EXTRA_UTILITIES, Config.healingAxe, new ItemHealingAxe());
            attachRenderer(Constants.ET_FUTURUM_REQUIEM, Config.totemOfUndying, ModItems.TOTEM_OF_UNDYING.get());
        } else {
            LOG.info("Did not attach any renderers because Backhand was not loaded.");
        }
    }

    private static void attachRenderer(final String modID, final boolean configValue, final Item item) {
        final String unlocalizedName = item.getUnlocalizedName();

        if (!Loader.isModLoaded(modID)) {
            LOG.info("Did not attach renderer for {}, mod {} was not found.", unlocalizedName, modID);
        } else if (!configValue) {
            LOG.info("Did not attach renderer for {}, it was disabled in the configuration.", unlocalizedName);
        } else {
            MinecraftForgeClient.registerItemRenderer(item, SubstituteRenderer.INSTANCE);
            LOG.info("Attached renderer for {}.", unlocalizedName);
        }
    }
}
