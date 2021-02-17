package simplelife.common.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.SimpleLife;
import simplelife.common.block.OverheadLamp;
import simplelife.common.block.furniture.*;

public class Furniture {

    // Furniture
    public static final Block TABLE = registerBlock(Table.identifier, new Table(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block TABLE_BELL = registerBlock(TableBell.identifier, new TableBell(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block KEYBOARD = registerBlock(Keyboard.identifier, new Keyboard(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block MONITOR = registerBlock(Monitor.identifier, new Monitor(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(5)));
    public static final Block COMPUTER = registerBlock(Computer.identifier, new Computer(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(5)));
    public static final Block OVERHEAD_LAMP = registerBlock(OverheadLamp.identifier, new OverheadLamp(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(12)));
    public static final Block WALLMOUNT = registerBlock(Wallmount.identifier, new Wallmount(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block CORNERBLOCK = registerBlock(Cornerblock.identifier, new Cornerblock(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block WORKBLOCK = registerBlock(Workblock.identifier, new Workblock(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block LOWTABLE = registerBlock(Lowtable.identifier, new Lowtable(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block BASIC_CHAIR = registerBlock(BasicChair.identifier, new BasicChair(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block WALL_TV = registerBlock(WallTv.identifier, new WallTv(FabricBlockSettings.of(Material.METAL).nonOpaque()));
    public static final Block SIMPLE_JAR = registerBlock(SimpleJar.identifier, new SimpleJar(FabricBlockSettings.of(Material.METAL).nonOpaque()));

    public static void init() {
        // This space is available for rent
    }

    private static Block registerBlock(String identifier, Block block) {
        Registry.register(Registry.ITEM, new Identifier(SimpleLife.MOD_ID, identifier),
                new BlockItem(block, new FabricItemSettings().group(SimpleLife.ITEM_GROUP))
        );
        return Registry.register(Registry.BLOCK, new Identifier(SimpleLife.MOD_ID, identifier), block);

    }

}
