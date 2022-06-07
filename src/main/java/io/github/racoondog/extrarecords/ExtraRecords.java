package io.github.racoondog.extrarecords;

import com.mojang.logging.LogUtils;
import io.github.racoondog.extrarecords.config.ModConfig;
import io.github.racoondog.extrarecords.datagen.ARRP;
import io.github.racoondog.extrarecords.datagen.Advancements;
import io.github.racoondog.extrarecords.datagen.DiscTexture;
import io.github.racoondog.extrarecords.datagen.Tags;
import io.github.racoondog.extrarecords.items.ExtraDiscItem;
import io.github.racoondog.extrarecords.items.ModItems;
import io.github.racoondog.extrarecords.util.Util;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;

public class ExtraRecords implements ModInitializer {
    public static final String MODID = "extrarecords";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ModConfig CONFIG;
    public static final RuntimeResourcePack RRP = RuntimeResourcePack.create(MODID);
    public static final ItemGroup EXTRARECORDS_ITEM_GROUP = FabricItemGroupBuilder.build(Util.id("item_group"), () -> new ItemStack(ModItems.BIOME_FEST));

    static {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        StringBuilder sb = new StringBuilder("Configs: ");
        for (var field : CONFIG.getClass().getDeclaredFields()) {
            try {
                sb.append("%s = %s ; ".formatted(field.getName(), field.get(CONFIG)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(sb.toString());
    }

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        Tags.registerTags();
        Advancements.registerAdvancements();

        if (!CONFIG.vanillaDrops) {
            LootTableEdits.registerLootTableEdits();
            WanderingTraderOffers.registerOffers();
        }

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            final ExtraDiscItem testDisc = new ExtraDiscItem(null, new FabricItemSettings(), true);
            final Identifier testDiscId = Util.id("test_disc");
            Registry.register(Registry.ITEM, testDiscId, testDisc);
            Tags.addDisc(new Pair<>(testDisc, testDiscId));
            ARRP.itemModel(testDiscId, DiscTexture.DDLC);
            RRP.dump();
        }

        RRPCallback.BEFORE_VANILLA.register(a -> a.add(RRP));
    }
}
