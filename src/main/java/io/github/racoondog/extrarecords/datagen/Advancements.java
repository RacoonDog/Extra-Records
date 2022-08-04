package io.github.racoondog.extrarecords.datagen;

import com.google.common.collect.Lists;
import io.github.racoondog.extrarecords.util.Util;
import net.minecraft.resource.ResourceType;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import static io.github.racoondog.extrarecords.ExtraRecords.CONFIG;
import static io.github.racoondog.extrarecords.ExtraRecords.RRP;

public class Advancements {
    public static void registerAdvancements() {
        if (CONFIG.minecraftOST) {
            createAdvancement("minecraft", "extrarecords:key", FrameType.GOAL, Lists.newArrayList("biome_fest", "blind_spots", "haunt_muskie", "aria_math", "dreiton", "taswell", "alpha", "the_end", "boss", "minecraft", "clark", "sweden", "subwoofer_lullaby", "living_mice", "haggstrom", "danny", "key", "oxygene", "dry_hands", "wet_hands", "mice_on_venus", "mutation", "moog_city_2", "beginning_2", "floating_trees", "concrete_halls", "dead_voxel", "warmth", "ballad_of_the_cats", "rubedo", "chrysopoeia", "so_below", "axolotl", "dragon_fish", "shuniji", "left_to_bloom", "comforting_memories", "floating_dream", "one_more_day", "an_ordinary_day", "infinite_amethyst", "stand_tall", "wending"));
        }
        if (CONFIG.helltakerOST) {
            createAdvancement("helltaker", "extrarecords:apropos", FrameType.GOAL, Lists.newArrayList("apropos", "epitomize", "luminescent", "vitality", "vitality_vip_edit", "brimstone", "epitomize_sinners_vip_edit", "epitomize_vip_edit", "alchemy", "titanium"));
        }
        if (CONFIG.ddlcOST) {
            createAdvancement("ddlc", "extrarecords:your_reality", FrameType.GOAL, Lists.newArrayList("daijoubu", "doki_doki_literature_club", "dreams_of_love_and_literature", "i_still_love_you", "my_confession", "my_feelings", "ohayou_sayori", "okay_everyone", "play_with_me", "poem_panic", "sayo-nara", "your_reality"));
        }
    }

    private static void createAdvancement(String path, String icon, String lang, FrameType frameType, String parent, String criteria, String requirements) {
        RRP.addResource(ResourceType.SERVER_DATA, Util.id("advancements/discs/" + path + ".json"), ADVANCEMENT_TEMPLATE.formatted(icon, lang, lang, frameType.toString().toLowerCase(Locale.ROOT), parent, criteria, requirements).getBytes(StandardCharsets.UTF_8));
    }

    private static void createAdvancement(String name, String icon, FrameType frameType, String criteria, String requirements) {
        createAdvancement(name, icon, name, frameType, "extrarecords:discs/first_disc", criteria, requirements);
    }

    private static void createAdvancement(String name, String icon, FrameType frameType, List<String> items) {
        createAdvancement(name, icon, frameType, criteria(items), requirements(items));
    }

    private static String criteria(List<String> items) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (i != 0) sb.append(",");
            sb.append("\"%s\":{\"trigger\":\"minecraft:inventory_changed\",\"conditions\":{\"items\":[{\"items\":[\"extrarecords:%s\"]}]}}".formatted(items.get(i), items.get(i)));
        }
        return sb.toString();
    }

    private static String requirements(List<String> items) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (i != 0) sb.append(",");
            sb.append("[\"%s\"]".formatted(items.get(i)));
        }
        return sb.toString();
    }

    private static final String ADVANCEMENT_TEMPLATE = "{\"display\":{\"icon\":{\"item\":\"%s\"},\"title\":{\"translate\":\"advancements.discs.%s.title\"},\"description\":{\"translate\":\"advancements.discs.%s.description\"},\"frame\":\"%s\"},\"parent\":\"%s\",\"criteria\":{%s},\"requirements\":[%s]}";

    private enum FrameType {
        NORMAL,
        GOAL,
        CHALLENGE;
    }
}
