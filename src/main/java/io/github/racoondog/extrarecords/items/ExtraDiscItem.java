package io.github.racoondog.extrarecords.items;

import io.github.racoondog.extrarecords.util.Util;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExtraDiscItem extends MusicDiscItem {
    public final boolean dropsFromCreeper;
    private final int length;

    public ExtraDiscItem(SoundEvent sound, Settings settings, boolean dropsFromCreeper, int length) {
        this(sound, settings, Rarity.RARE, dropsFromCreeper, length);
    }

    public ExtraDiscItem(SoundEvent sound, Settings settings, Rarity rarity, boolean dropsFromCreeper, int length) {
        super(1, sound, settings.maxCount(1).rarity(rarity), length);
        this.dropsFromCreeper = dropsFromCreeper;
        this.length = length;
    }

    @Override
    public String getTranslationKey() {
        return "item.minecraft.music_disc_13";
    }

    @Override
    public MutableText getDescription() {
        return Text.translatable(this.getOrCreateTranslationKey() + ".desc");
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.extrarecords.disc.duration", Util.formatDuration(this.length)).formatted(Formatting.GRAY));
    }
}
