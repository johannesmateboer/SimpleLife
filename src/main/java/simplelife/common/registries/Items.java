package simplelife.common.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.SimpleLife;
import simplelife.common.item.BleachItem;
import simplelife.common.item.CaramelItem;
import simplelife.common.item.SaltItem;
import simplelife.common.item.SilkStringItem;
import simplelife.init.FoodComponentBuilder;

public class Items {

    public static final SaltItem SALT_ITEM = registerItem("salt_item", new SaltItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
    public static final BleachItem BLEACH_ITEM = registerItem("bleach_item", new BleachItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP).food(FoodComponentBuilder.getBleachFoodComponent())));
    public static final SilkStringItem SILK_STRING_ITEM = registerItem("silk_string_item", new SilkStringItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
    public static final CaramelItem CARAMEL_ITEM = registerItem("caramel_item", new CaramelItem(new FabricItemSettings().group(SimpleLife.ITEM_GROUP).food(FoodComponentBuilder.getDefaultFoodComponent(CaramelItem.saturationModifier))));

    public static void init() {
        // Your text could be here.
    }

    private static <I extends Item> I registerItem(String identifier, I item) {
        Registry.register(Registry.ITEM, new Identifier(SimpleLife.MOD_ID, identifier), item);
        return item;
    }
}
