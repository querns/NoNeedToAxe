package io.gbs.noneedtoaxe.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import io.gbs.noneedtoaxe.Config;
import io.gbs.noneedtoaxe.Constants;

@SuppressWarnings("unused")
@LateMixin
public class LateMixinsLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.noneedtoaxe.late.json";
    }

    @Nonnull
    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        if (Config.healingAxe && loadedMods.contains(Constants.EXTRA_UTILITIES)) {
            mixins.add("MixinExtraUtilities_RenderItemMultiTransparency");
        }
        return mixins;
    }
}
