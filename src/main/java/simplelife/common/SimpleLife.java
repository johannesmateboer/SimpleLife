package simplelife.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.block.OverheadLamp;
import simplelife.common.block.entities.CabinetEntity;
import simplelife.common.block.entities.WorktableEntity;
import simplelife.common.block.furniture.*;
import simplelife.common.gui.WorktableScreenHandler;
import simplelife.common.item.LottBoots;
import simplelife.common.registries.Items;
import simplelife.common.registries.Lamps;
import simplelife.init.LootGenerator;
import simplelife.materials.LottArmorMaterial;

public class SimpleLife implements ModInitializer {

    public static final String MOD_ID = "simplelife";

    // Furniture
    public static final Block TABLE = new Table(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block TABLE_BELL = new TableBell(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block KEYBOARD = new Keyboard(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block MONITOR = new Monitor(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(5));
    public static final Block COMPUTER = new Computer(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(5));

    public static final Block OVERHEAD_LAMP = new OverheadLamp(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(12));
    public static final Block WALLMOUNT = new Wallmount(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block CORNERBLOCK = new Cornerblock(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block WORKBLOCK = new Workblock(FabricBlockSettings.of(Material.METAL).nonOpaque());
    public static final Block LOWTABLE = new Lowtable(FabricBlockSettings.of(Material.METAL).nonOpaque());

    // Worktable
    public static final Block WORKTABLE;
    public static final BlockItem WORKTABLE_ITEM;
    public static final Identifier WORKTABLE_IDENTIFIER = new Identifier(MOD_ID, "worktable");
    public static BlockEntityType<WorktableEntity> WORKTABLE_ENTITY;
    public static final ScreenHandlerType<WorktableScreenHandler> WORKTABLE_SCREEN_HANDLER;

    // Cabinet
    public static final Block CABINET;
    public static final BlockItem CABINET_ITEM;
    public static final Identifier CABINET_IDENTIFIER = new Identifier(MOD_ID, "cabinet");
    public static BlockEntityType<CabinetEntity> CABINET_ENTITY;
    public static final ScreenHandlerType<WorktableScreenHandler> CABINET_SCREEN_HANDLER;

    // Set the ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general"))
            .icon(() -> new ItemStack(TABLE))
            .build();

    // Lott Boots
    public static final ArmorMaterial LottArmorMaterial = new LottArmorMaterial();
    public static final LottBoots LOTT_BOOTS = new LottBoots();

    public static final Identifier SOUND_TABLE_BELL_ID = new Identifier(SimpleLife.MOD_ID, "table_bell_ring");
    public static SoundEvent SOUND_TABLE_BELL = new SoundEvent(SOUND_TABLE_BELL_ID);


    static {
        Lamps.init();
        Items.init();

        WORKTABLE = Registry.register(Registry.BLOCK, WORKTABLE_IDENTIFIER, new Worktable(FabricBlockSettings.copyOf(Blocks.CHEST).nonOpaque()));
        WORKTABLE_ITEM = Registry.register(Registry.ITEM, WORKTABLE_IDENTIFIER, new BlockItem(WORKTABLE, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        WORKTABLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, WORKTABLE_IDENTIFIER, BlockEntityType.Builder.create(WorktableEntity::new, WORKTABLE).build(null));
        WORKTABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WORKTABLE_IDENTIFIER, WorktableScreenHandler::new);

        CABINET = Registry.register(Registry.BLOCK, CABINET_IDENTIFIER, new Cabinet(FabricBlockSettings.copyOf(Blocks.CHEST).nonOpaque()));
        CABINET_ITEM = Registry.register(Registry.ITEM, CABINET_IDENTIFIER, new BlockItem(CABINET, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        CABINET_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, CABINET_IDENTIFIER, BlockEntityType.Builder.create(CabinetEntity::new, CABINET).build(null));
        CABINET_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CABINET_IDENTIFIER, WorktableScreenHandler::new);
    }

    @Override
    public void onInitialize() {

        // Furniture
        registerBlock(Table.identifier, TABLE);
        registerBlock(TableBell.identifier, TABLE_BELL);
        registerBlock(Keyboard.identifier, KEYBOARD);
        registerBlock(Monitor.identifier, MONITOR);
        registerBlock(Computer.identifier, COMPUTER);

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "overhead_lamp"), OVERHEAD_LAMP);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "overhead_lamp"), new BlockItem(OVERHEAD_LAMP, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));

        registerBlock(Wallmount.identifier, WALLMOUNT);
        registerBlock(Cornerblock.identifier, CORNERBLOCK);
        registerBlock(Workblock.identifier, WORKBLOCK);
        registerBlock(Lowtable.identifier, LOWTABLE);

        // Boots
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lott_boots"), LOTT_BOOTS);
        LootGenerator.initLoot();

        //Sounds
        Registry.register(Registry.SOUND_EVENT, SOUND_TABLE_BELL_ID, SOUND_TABLE_BELL);
    }

    private static void registerBlock(String identifier, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, identifier), block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, identifier),
                new BlockItem(block, new FabricItemSettings().group(SimpleLife.ITEM_GROUP))
        );
    }

}
