package io.github.racoondog.extrarecords;

import io.github.racoondog.extrarecords.config.ModConfig;
import io.github.racoondog.extrarecords.datagen.ARRP;
import io.github.racoondog.extrarecords.datagen.DiscTexture;
import io.github.racoondog.extrarecords.datagen.Tags;
import io.github.racoondog.extrarecords.items.ExtraDiscItem;
import io.github.racoondog.extrarecords.items.ModItems;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtraRecords implements ModInitializer {
    public static final String MODID = "extrarecords";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ModConfig CONFIG;
    public static final RuntimeResourcePack RRP = RuntimeResourcePack.create(MODID);

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

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            final ExtraDiscItem testDisc = new ExtraDiscItem(null, new FabricItemSettings());
            final Identifier testDiscId = new Identifier(MODID, "test_disc");
            Registry.register(Registry.ITEM, testDiscId, testDisc);
            ModItems.addedDiscs.add(testDisc);
            Tags.addDisc(testDiscId);
            ARRP.itemModel(testDiscId, DiscTexture.DDLC);
            RRP.dump();
        }

        RRPCallback.BEFORE_VANILLA.register(a -> a.add(RRP));
    }
}
