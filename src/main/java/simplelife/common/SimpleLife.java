package simplelife.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.block.WhiteLamp;
import simplelife.common.item.UselessStick;

public class SimpleLife implements ModInitializer {

    // LampSettings
    private static int hardness = 3;

    // Initialize the blocks
    public static final Block WHITE_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block RED_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block BLUE_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block YELLOW_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block GREEN_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block BLACK_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block GRAY_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));
    public static final Block PURPLE_LAMP = new WhiteLamp(FabricBlockSettings.of(Material.REDSTONE_LAMP).luminance(10).hardness(hardness));

    // Set the ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier("simplelife", "general"))
            .icon(() -> new ItemStack(WHITE_LAMP))
            .build();

    @Override
    public void onInitialize() {
        // All the lamps!
        Registry.register(Registry.BLOCK, new Identifier("simplelife", "white_lamp"), WHITE_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "white_lamp"), new BlockItem(WHITE_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "red_lamp"), RED_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "red_lamp"), new BlockItem(RED_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "blue_lamp"), BLUE_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "blue_lamp"), new BlockItem(BLUE_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "yellow_lamp"), YELLOW_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "yellow_lamp"), new BlockItem(YELLOW_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "green_lamp"), GREEN_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "green_lamp"), new BlockItem(GREEN_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "black_lamp"), BLACK_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "black_lamp"), new BlockItem(BLACK_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "gray_lamp"), GRAY_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "gray_lamp"), new BlockItem(GRAY_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("simplelife", "purple_lamp"), PURPLE_LAMP);
        Registry.register(Registry.ITEM, new Identifier("simplelife", "purple_lamp"), new BlockItem(PURPLE_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
    }


}
