package io.github.racoondog.extrarecords.datagen;

import com.google.common.collect.Lists;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.util.Identifier;

import java.util.List;

import static io.github.racoondog.extrarecords.ExtraRecords.RRP;

public class Tags {
    private static final List<Identifier> addedDiscs = Lists.newArrayList();

    public static void addDisc(Identifier identifier) {
        addedDiscs.add(identifier);
    }

    public static void registerTags() {
        RRP.addTag(new Identifier("minecraft", "items/creeper_drop_music_discs"), createTag(addedDiscs));
        RRP.addTag(new Identifier("c", "items/music_discs"), JTag.tag().tag(new Identifier("minecraft", "creeper_drop_music_discs")).add(new Identifier("minecraft", "music_disc_otherside")).add(new Identifier("minecraft", "music_disc_otherside")));
    }

    private static JTag createTag(List<Identifier> discs) {
        final JTag tag = JTag.tag();
        for (var disc : discs) {
            tag.add(disc);
        }
        return tag;
    }
}
