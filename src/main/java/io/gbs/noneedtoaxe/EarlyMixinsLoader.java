package io.gbs.noneedtoaxe;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@IFMLLoadingPlugin.MCVersion("1.7.10")
public class EarlyMixinsLoader implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public String getMixinConfig() {
        // rename the associated .json file by replacing the "mymodid" with your own mod ID
        // in the .json file edit the "package" and "refmap" properties to match your mod
        // also edit the "refmap" property in the "noneedtoaxe.mymodid.json" file
        return "noneedtoaxe.mymodid.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        // Register your noneedtoaxe here by adding them to the list.
        // The early noneedtoaxe are noneedtoaxe that target minecraft/forge classes
        // The early noneedtoaxe should be placed in the "noneedtoaxe/early" package
        // If your noneedtoaxe targets a class from another mod, register it in the LateMixinLoader
        List<String> mixins = new ArrayList<>();

        // The parameter loadedCoreMods contains the name of coremods that are currently loaded
        // you can check this Set to decide to load certain noneedtoaxe or not.
        //if (!loadedCoreMods.contains("optifine.OptiFineForgeTweaker")) {
        //    // this noneedtoaxe won't be loaded if Optifine is present
        //    noneedtoaxe.add("MixinClass");
        //}

        if (FMLLaunchHandler.side().isClient()) {
            // register here your noneedtoaxe that should only be loaded on the client
            mixins.add("MixinMinecraft_Example");// this is an example you should delete it and the associated mixin class as well
        } else {
            // register here your noneedtoaxe that should only be loaded on the dedicated server
            // noneedtoaxe.add("MixinClass");
        }

        // register here your noneedtoaxe that should be loaded on both sides
        // noneedtoaxe.add("MixinClass");

        // If you need more complex registration logic consider switching to the IMixins registration
        // system see com.gtnewhorizon.gtnhmixins.builders.IMixins
        return mixins;
    }
}
