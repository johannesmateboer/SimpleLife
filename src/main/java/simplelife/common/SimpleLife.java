package simplelife.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.block.*;
import simplelife.common.item.BleachItem;
import simplelife.common.item.CaramelItem;
import simplelife.common.item.SaltItem;
import simplelife.init.FoodComponentBuilder;
import simplelife.init.LampGenerator;

public class SimpleLife implements ModInitializer {

    public static final String MOD_ID = "simplelife";

    // Initialize the blocks
    public static final Block WHITE_LAMP = new WhiteLamp(LampGenerator.getDefaultLampSettings());
    public static final Block RED_LAMP = new RedLamp(LampGenerator.getDefaultLampSettings());
    public static final Block BLUE_LAMP = new BlueLamp(LampGenerator.getDefaultLampSettings());
    public static final Block YELLOW_LAMP = new YellowLamp(LampGenerator.getDefaultLampSettings());
    public static final Block GREEN_LAMP = new GreenLamp(LampGenerator.getDefaultLampSettings());
    public static final Block BLACK_LAMP = new BlackLamp(LampGenerator.getDefaultLampSettings());
    public static final Block GRAY_LAMP = new GrayLamp(LampGenerator.getDefaultLampSettings());
    public static final Block PURPLE_LAMP = new PurpleLamp(LampGenerator.getDefaultLampSettings());

    // Set the ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general"))
            .icon(() -> new ItemStack(WHITE_LAMP))
            .build();

    // Initialize the items
    public static final SaltItem SALT_ITEM = new SaltItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP));
    public static final BleachItem BLEACH_ITEM = new BleachItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP)
            .food(FoodComponentBuilder.getBleachFoodComponent()));

    public static final CaramelItem CARAMEL_ITEM = new CaramelItem(new FabricItemSettings()
            .group(SimpleLife.ITEM_GROUP).food(FoodComponentBuilder.getDefaultFoodComponent(CaramelItem.saturationModifier)));

    @Override
    public void onInitialize() {
        // All the lamps!
        registerLamp(WhiteLamp.identifier, WHITE_LAMP);
        registerLamp(RedLamp.identifier, RED_LAMP);
        registerLamp(BlueLamp.identifier, BLUE_LAMP);
        registerLamp(YellowLamp.identifier, YELLOW_LAMP);
        registerLamp(GreenLamp.identifier, GREEN_LAMP);
        registerLamp(BlackLamp.identifier, BLACK_LAMP);
        registerLamp(GrayLamp.identifier, GRAY_LAMP);
        registerLamp(PurpleLamp.identifier, PURPLE_LAMP);

        // Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "salt_item"), SALT_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bleach_item"), BLEACH_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "caramel_item"), CARAMEL_ITEM);
    }

    private static void registerLamp(String identifier, Block lamp) {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, identifier), lamp);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, identifier), new BlockItem(lamp, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
    }


}
