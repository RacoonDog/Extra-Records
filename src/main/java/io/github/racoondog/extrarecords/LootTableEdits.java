package io.github.racoondog.extrarecords;

import io.github.racoondog.extrarecords.items.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import static io.github.racoondog.extrarecords.ExtraRecords.CONFIG;

public class LootTableEdits {
    private static final Identifier ELDER_GUARDIAN_ID = EntityType.ELDER_GUARDIAN.getLootTableId();
    private static final Identifier ENDER_DRAGON_ID = EntityType.ENDER_DRAGON.getLootTableId();

    private static final Identifier UNDERWATER_RUIN_SMALL_ID = LootTables.UNDERWATER_RUIN_SMALL_CHEST;
    private static final Identifier UNDERWATER_RUIN_BIG_ID = LootTables.UNDERWATER_RUIN_SMALL_CHEST;
    private static final Identifier BURIED_TREASURE_ID = LootTables.BURIED_TREASURE_CHEST;
    private static final Identifier SPAWN_BONUS_ID = LootTables.SPAWN_BONUS_CHEST;
    private static final Identifier NETHER_BRIDGE_ID = LootTables.NETHER_BRIDGE_CHEST;
    private static final Identifier BASTION_TREASURE_ID = LootTables.BASTION_TREASURE_CHEST;
    private static final Identifier BASTION_OTHER_ID = LootTables.BASTION_OTHER_CHEST;
    private static final Identifier BASTION_BRIDGE_ID = LootTables.BASTION_BRIDGE_CHEST;
    private static final Identifier BASTION_HOGLIN_ID = LootTables.BASTION_HOGLIN_STABLE_CHEST;
    private static final Identifier RUINED_PORTAL_ID = LootTables.RUINED_PORTAL_CHEST;
    private static final Identifier END_CITY_ID = LootTables.END_CITY_TREASURE_CHEST;

    private static final Identifier PIGLIN_BARTERING = LootTables.PIGLIN_BARTERING_GAMEPLAY;

    public static void registerLootTableEdits() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, table, setter) -> {
            if (CONFIG.minecraftOST) {
                if (ELDER_GUARDIAN_ID.equals(id)) {
                    table.pool(create(ModItems.DRAGON_FISH, 0.112f));
                } else if (UNDERWATER_RUIN_SMALL_ID.equals(id) || UNDERWATER_RUIN_BIG_ID.equals(id)) {
                    table.pool(create(ModItems.SHUNIJI, 0.112f));
                } else if (BURIED_TREASURE_ID.equals(id)) {
                    table.pool(create(ModItems.AXOLOTL, 0.112f));
                } else if (SPAWN_BONUS_ID.equals(id)) {
                    table.pool(create(ModItems.LEFT_TO_BLOOM, ModItems.MINECRAFT, ModItems.SWEDEN));
                } else if (BASTION_TREASURE_ID.equals(id)) {
                    table.pool(create(0.112f, ModItems.RUBEDO, ModItems.CHRYSOPOEIA, ModItems.SO_BELOW));
                } else if (BASTION_OTHER_ID.equals(id)) {
                    table.pool(create(ModItems.RUBEDO, 0.056f));
                } else if (BASTION_BRIDGE_ID.equals(id)) {
                    table.pool(create(ModItems.CHRYSOPOEIA, 0.056f));
                } else if (BASTION_HOGLIN_ID.equals(id)) {
                    table.pool(create(ModItems.SO_BELOW, 0.056f));
                } else if (NETHER_BRIDGE_ID.equals(id)) {
                    table.pool(create(0.056f, ModItems.CONCRETE_HALLS, ModItems.DEAD_VOXEL));
                } else if (RUINED_PORTAL_ID.equals(id)) {
                    table.pool(create(ModItems.WARMTH, 0.112f));
                } else if (ENDER_DRAGON_ID.equals(id)) {
                    table.pool(create(ModItems.BOSS, 0.33f));
                } else if (END_CITY_ID.equals(id)) {
                    table.pool(create(0.112f, ModItems.ALPHA, ModItems.THE_END));
                } else if (PIGLIN_BARTERING.equals(id)) {
                    table.pool(create(ModItems.BALLAD_OF_THE_CATS, 0.112f));
                }
            }
        });
    }

    private static LootPool.Builder create(Item item) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(item));
    }
    private static LootPool.Builder create(Item item, float chance) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(item)).conditionally(RandomChanceLootCondition.builder(chance).build());
    }
    private static LootPool.Builder create(Item... items) {
        final LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1));
        for (var item : items) {
            builder.with(ItemEntry.builder(item).weight(1));
        }
        return builder;
    }
    private static LootPool.Builder create(float chance, Item... items) {
        final LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1));
        chance = chance / items.length;
        for (var item : items) {
            builder.with(ItemEntry.builder(item).weight(1)).conditionally(RandomChanceLootCondition.builder(chance).build());
        }
        return builder;
    }
}
