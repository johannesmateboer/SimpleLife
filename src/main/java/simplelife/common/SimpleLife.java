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
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import simplelife.common.block.RedstoneLock;
import simplelife.common.block.entities.RedstoneLockEntity;
import simplelife.common.block.entities.CabinetEntity;
import simplelife.common.block.entities.WorktableEntity;
import simplelife.common.block.furniture.Cabinet;
import simplelife.common.block.furniture.Worktable;
import simplelife.common.item.RedstoneLockKey;
import simplelife.common.gui.WorktableScreenHandler;
import simplelife.common.item.LottBoots;
import simplelife.common.registries.Furniture;
import simplelife.common.registries.Items;
import simplelife.common.registries.Lamps;
import simplelife.init.LootGenerator;
import simplelife.materials.LottArmorMaterial;

public class SimpleLife implements ModInitializer {

    public static final String MOD_ID = "simplelife";

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

    // Redstone Lock
    public static final Block REDSTONE_LOCK;
    public static final BlockItem REDSTONE_LOCK_ITEM;
    public static final Identifier REDSTONE_LOCK_IDENTIFIER = new Identifier(MOD_ID, "redstone_lock");
    public static BlockEntityType<RedstoneLockEntity> REDSTONE_LOCK_ENTITY;
    public static final RedstoneLockKey REDSTONE_LOCK_KEY;

    // Set the ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "general"))
            .icon(() -> new ItemStack(Furniture.TABLE))
            .build();

    // Lott Boots
    public static final ArmorMaterial LottArmorMaterial = new LottArmorMaterial();
    public static final LottBoots LOTT_BOOTS = new LottBoots();

    public static final Identifier SOUND_TABLE_BELL_ID = new Identifier(SimpleLife.MOD_ID, "table_bell_ring");
    public static SoundEvent SOUND_TABLE_BELL = new SoundEvent(SOUND_TABLE_BELL_ID);

    static {
        Lamps.init();
        Items.init();
        Furniture.init();

        WORKTABLE = Registry.register(Registry.BLOCK, WORKTABLE_IDENTIFIER, new Worktable(FabricBlockSettings.copyOf(Blocks.CHEST).nonOpaque()));
        WORKTABLE_ITEM = Registry.register(Registry.ITEM, WORKTABLE_IDENTIFIER, new BlockItem(WORKTABLE, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        WORKTABLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, WORKTABLE_IDENTIFIER, BlockEntityType.Builder.create(WorktableEntity::new, WORKTABLE).build(null));
        WORKTABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WORKTABLE_IDENTIFIER, WorktableScreenHandler::new);

        CABINET = Registry.register(Registry.BLOCK, CABINET_IDENTIFIER, new Cabinet(FabricBlockSettings.copyOf(Blocks.CHEST).nonOpaque()));
        CABINET_ITEM = Registry.register(Registry.ITEM, CABINET_IDENTIFIER, new BlockItem(CABINET, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        CABINET_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, CABINET_IDENTIFIER, BlockEntityType.Builder.create(CabinetEntity::new, CABINET).build(null));
        CABINET_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CABINET_IDENTIFIER, WorktableScreenHandler::new);

        REDSTONE_LOCK = Registry.register(Registry.BLOCK, REDSTONE_LOCK_IDENTIFIER, new RedstoneLock(FabricBlockSettings.of(Material.GLASS).hardness(10f).nonOpaque()));
        REDSTONE_LOCK_ITEM = Registry.register(Registry.ITEM, REDSTONE_LOCK_IDENTIFIER, new BlockItem(REDSTONE_LOCK, new FabricItemSettings().group(SimpleLife.ITEM_GROUP)));
        REDSTONE_LOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, REDSTONE_LOCK_IDENTIFIER, BlockEntityType.Builder.create(RedstoneLockEntity::new, REDSTONE_LOCK).build(null));
        REDSTONE_LOCK_KEY = new RedstoneLockKey(new FabricItemSettings().group(SimpleLife.ITEM_GROUP).maxCount(1));
    }

    @Override
    public void onInitialize() {
        // Boots
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lott_boots"), LOTT_BOOTS);
        LootGenerator.initLoot();

        //Sounds
        Registry.register(Registry.SOUND_EVENT, SOUND_TABLE_BELL_ID, SOUND_TABLE_BELL);

        // Redstone Lock
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "redstone_lock_key"), REDSTONE_LOCK_KEY);
    }
}
