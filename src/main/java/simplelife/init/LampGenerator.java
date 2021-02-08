package simplelife.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;

public class LampGenerator {

    private static final int hardness = 3;
    private static final int luminance = 11;

    /**
     * Returns default settings for all lamps
     * @return FabricBlockSettings
     */
    public static FabricBlockSettings getDefaultLampSettings() {
        return FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(luminance).hardness(hardness).nonOpaque();
    }
}
