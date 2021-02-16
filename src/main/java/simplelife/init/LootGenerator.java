package simplelife.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import simplelife.common.SimpleLife;
import simplelife.common.registries.Items;

public class LootGenerator {

    private static Identifier OAK_LEAF_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/acacia_leaves");

    public static void initLoot() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (OAK_LEAF_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.2f))
                        .withEntry(ItemEntry.builder(Items.SILK_STRING_ITEM).build());
                supplier.withPool(poolBuilder.build());
            }
        });
    }


}
