package io.github.racoondog.extrarecords;

import io.github.racoondog.extrarecords.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExtraRecordsClient implements ClientModInitializer {
    public static final ItemGroup EXTRARECORDS_ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(ExtraRecords.MODID, "item_group"))
            .icon(() -> new ItemStack(ModItems.BIOME_FEST))
            .appendItems(stacks -> {
                for (var item : ModItems.addedDiscs) {
                    stacks.add(new ItemStack(item));
                }
            })
            .build();

    @Override
    public void onInitializeClient() {}
}
