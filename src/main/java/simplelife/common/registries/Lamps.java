package simplelife.common.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.SimpleLife;
import simplelife.common.block.*;
import simplelife.init.LampGenerator;

public class Lamps {

    public static final Block WHITE_LAMP = registerLamp(WhiteLamp.identifier, new WhiteLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block RED_LAMP = registerLamp(RedLamp.identifier, new RedLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block BLUE_LAMP = registerLamp(BlueLamp.identifier, new BlueLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block YELLOW_LAMP = registerLamp(YellowLamp.identifier, new YellowLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block GREEN_LAMP = registerLamp(GreenLamp.identifier, new GreenLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block BLACK_LAMP = registerLamp(BlackLamp.identifier, new BlackLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block GRAY_LAMP = registerLamp(GrayLamp.identifier, new GrayLamp(LampGenerator.getDefaultLampSettings()));
    public static final Block PURPLE_LAMP = registerLamp(PurpleLamp.identifier, new PurpleLamp(LampGenerator.getDefaultLampSettings()));

    public static void init() {
        // Does nothing, just here to start the class
    }

    private static Block registerLamp(String identifier, Block block) {
        block = Registry.register(Registry.BLOCK, new Identifier(SimpleLife.MOD_ID, identifier), block);
        Registry.register(Registry.ITEM, new Identifier(SimpleLife.MOD_ID, identifier), new BlockItem(block, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        return block;
    }

}
