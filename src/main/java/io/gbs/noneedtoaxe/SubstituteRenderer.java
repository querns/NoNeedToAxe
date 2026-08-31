package io.gbs.noneedtoaxe;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import xonin.backhand.api.core.BackhandUtils;

public enum SubstituteRenderer implements IItemRenderer {

    INSTANCE;

    @Override
    public boolean handleRenderType(final ItemStack item, final ItemRenderType type) {
        return ItemStack.areItemStacksEqual(item, BackhandUtils.getOffhandItem(Minecraft.getMinecraft().thePlayer))
            && type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper(final ItemRenderType type, final ItemStack item,
        final ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(final ItemRenderType type, final ItemStack item, final Object... data) {
        // Do nothing, as we aren't rendering the item!
    }
}
