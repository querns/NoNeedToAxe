package io.gbs.noneedtoaxe.mixins.late;

import com.rwtema.extrautils.item.RenderItemMultiTransparency;
import io.gbs.noneedtoaxe.Config;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.spongepowered.asm.mixin.Mixin;

import com.rwtema.extrautils.item.ItemHealingAxe;

import io.gbs.noneedtoaxe.SubstituteRenderer;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderItemMultiTransparency.class)
public class MixinExtraUtilities_RenderItemMultiTransparency {

    @Inject(
        method = "renderItem",
        at = @At(
            value = "HEAD",
            ordinal = 0
        ),
        remap = false,
        cancellable = true)
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object[] data, final CallbackInfo ci) {
        if (Config.healingAxe && item.getItem() instanceof ItemHealingAxe && SubstituteRenderer.INSTANCE.handleRenderType(item, type)) {
            ci.cancel();
        }
    }
}
