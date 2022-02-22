package io.github.racoondog.extrarecords.datagen;

import com.google.common.collect.Lists;
import io.github.racoondog.extrarecords.items.ExtraDiscItem;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.List;

import static io.github.racoondog.extrarecords.ExtraRecords.RRP;

public class Tags {
    public static final List<Pair<Item, Identifier>> addedDiscs = Lists.newArrayList();

    public static void addDisc(Pair<Item, Identifier> pair) {
        addedDiscs.add(pair);
    }

    public static void registerTags() {
        final JTag creeperDropMusicDiscs = JTag.tag();
        for (var pair : addedDiscs) {
            final ExtraDiscItem disc = (ExtraDiscItem) pair.getLeft();
            if (disc.dropsFromCreeper) {
                creeperDropMusicDiscs.add(pair.getRight());
            }
        }
        RRP.addTag(new Identifier("minecraft", "items/creeper_drop_music_discs"), creeperDropMusicDiscs);
        RRP.addTag(new Identifier("minecraft", "items/music_discs"), createTag(addedDiscs).tag(new Identifier("minecraft", "creeper_drop_music_discs")).add(new Identifier("minecraft", "music_disc_otherside")).add(new Identifier("minecraft", "music_disc_otherside")));
        RRP.addTag(new Identifier("c", "items/music_discs"), JTag.tag().tag(new Identifier("minecraft", "music_discs")));

    }

    private static JTag createTag(List<Pair<Item, Identifier>> discs) {
        final JTag tag = JTag.tag();
        for (var disc : discs) {
            tag.add(disc.getRight());
        }
        return tag;
    }
}
