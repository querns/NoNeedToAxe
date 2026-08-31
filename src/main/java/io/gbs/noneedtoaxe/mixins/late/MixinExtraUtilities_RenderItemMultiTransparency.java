package io.gbs.noneedtoaxe.mixins.late;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rwtema.extrautils.item.ItemHealingAxe;
import com.rwtema.extrautils.item.RenderItemMultiTransparency;

import io.gbs.noneedtoaxe.Config;
import io.gbs.noneedtoaxe.SubstituteRenderer;

@Mixin(RenderItemMultiTransparency.class)
public class MixinExtraUtilities_RenderItemMultiTransparency {

    @Inject(method = "renderItem", at = @At(value = "HEAD", ordinal = 0), remap = false, cancellable = true)
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object[] data,
        final CallbackInfo ci) {
        if (Config.healingAxe && item.getItem() instanceof ItemHealingAxe
            && SubstituteRenderer.INSTANCE.handleRenderType(item, type)) {
            ci.cancel();
        }
    }
}
