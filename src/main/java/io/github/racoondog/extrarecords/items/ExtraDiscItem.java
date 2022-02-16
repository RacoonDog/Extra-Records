package io.github.racoondog.extrarecords.items;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;

public class ExtraDiscItem extends MusicDiscItem {
    public ExtraDiscItem(SoundEvent sound, Settings settings) {
        super(1, sound, settings.maxCount(1).rarity(Rarity.RARE));
    }

    public ExtraDiscItem(SoundEvent sound, Settings settings, Rarity rarity) {
        super(1, sound, settings.maxCount(1).rarity(rarity));
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
