package io.github.racoondog.extrarecordscore.util;

import io.github.racoondog.extrarecordscore.ExtrarecordsCore;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Disc extends MusicDiscItem {

    public Disc(SoundEvent sound, Settings settings, Rarity rarity) {
        super(1, sound, settings.maxCount(1).rarity(rarity).group(ExtrarecordsCore.MINECRAFT_GROUP));
    }

    public static Disc createDisc(String name) {
        Identifier id = new Identifier(ExtrarecordsCore.modID, name);
        SoundEvent event = new SoundEvent(id);
        Disc item = new Disc(event, new FabricItemSettings(), Rarity.RARE);
        Registry.register(Registry.ITEM, id, item);
        Registry.register(Registry.SOUND_EVENT, id, event);
        return item;
    }
    public static Disc createDisc(String name, SoundEvent event) {
        Identifier id = new Identifier(ExtrarecordsCore.modID, name);
        Disc item = new Disc(event, new FabricItemSettings(), Rarity.RARE);
        Registry.register(Registry.ITEM, id, item);
        return item;
    }

    @Override
    public String getTranslationKey() {
        return "item.minecraft.music_disc_13";
    }
    @Override
    public MutableText getDescription() {
        return new TranslatableText(this.getOrCreateTranslationKey() + ".desc");
    }
}