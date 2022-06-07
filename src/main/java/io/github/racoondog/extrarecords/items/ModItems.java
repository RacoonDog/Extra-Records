package io.github.racoondog.extrarecords.items;

import io.github.racoondog.extrarecords.ExtraRecords;
import io.github.racoondog.extrarecords.util.Util;
import io.github.racoondog.extrarecords.datagen.ARRP;
import io.github.racoondog.extrarecords.datagen.DiscTexture;
import io.github.racoondog.extrarecords.datagen.Tags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

import static io.github.racoondog.extrarecords.ExtraRecords.CONFIG;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class ModItems {
    public static final Item BIOME_FEST = create("biome_fest", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item BLIND_SPOTS = create("blind_spots", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item HAUNT_MUSKIE = create("haunt_muskie", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item ARIA_MATH = create("aria_math", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item DREITON = create("dreiton", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item TASWELL = create("taswell", () -> CONFIG.minecraftOST, DiscTexture.CREATIVE);
    public static final Item ALPHA = create("alpha", SoundEvents.MUSIC_CREDITS, () -> CONFIG.minecraftOST, DiscTexture.END, () -> CONFIG.vanillaDrops);
    public static final Item THE_END = create("the_end", SoundEvents.MUSIC_END, () -> CONFIG.minecraftOST, DiscTexture.END, () -> CONFIG.vanillaDrops);
    public static final Item BOSS = create("boss", SoundEvents.MUSIC_DRAGON, () -> CONFIG.minecraftOST, DiscTexture.END, () -> CONFIG.vanillaDrops);
    public static final Item MINECRAFT = create("minecraft", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item CLARK = create("clark", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item SWEDEN = create("sweden", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item SUBWOOFER_LULLABY = create("subwoofer_lullaby", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item LIVING_MICE = create("living_mice", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item HAGGSTROM = create("haggstrom", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item DANNY = create("danny", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item KEY = create("key", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item OXYGENE = create("oxygene", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item DRY_HANDS = create("dry_hands", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item WET_HANDS = create("wet_hands", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item MICE_ON_VENUS = create("mice_on_venus", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD);
    public static final Item MUTATION = create("mutation", () -> CONFIG.minecraftOST, DiscTexture.MENU, () -> CONFIG.vanillaDrops);
    public static final Item MOOG_CITY_2 = create("moog_city_2", () -> CONFIG.minecraftOST, DiscTexture.MENU, () -> CONFIG.vanillaDrops);
    public static final Item BEGINNING_2 = create("beginning_2", () -> CONFIG.minecraftOST, DiscTexture.MENU, () -> CONFIG.vanillaDrops);
    public static final Item FLOATING_TREES = create("floating_trees", () -> CONFIG.minecraftOST, DiscTexture.MENU, () -> CONFIG.vanillaDrops);
    public static final Item CONCRETE_HALLS = create("concrete_halls", () -> CONFIG.minecraftOST, DiscTexture.NETHER, () -> CONFIG.vanillaDrops);
    public static final Item DEAD_VOXEL = create("dead_voxel", () -> CONFIG.minecraftOST, DiscTexture.NETHER, () -> CONFIG.vanillaDrops);
    public static final Item WARMTH = create("warmth", () -> CONFIG.minecraftOST, DiscTexture.NETHER, () -> CONFIG.vanillaDrops);
    public static final Item BALLAD_OF_THE_CATS = create("ballad_of_the_cats", () -> CONFIG.minecraftOST, DiscTexture.NETHER, () -> CONFIG.vanillaDrops);
    public static final Item RUBEDO = create("rubedo", () -> CONFIG.minecraftOST, DiscTexture.NETHER_UPDATE, () -> CONFIG.vanillaDrops);
    public static final Item CHRYSOPOEIA = create("chrysopoeia", () -> CONFIG.minecraftOST, DiscTexture.NETHER_UPDATE, () -> CONFIG.vanillaDrops);
    public static final Item SO_BELOW = create("so_below", () -> CONFIG.minecraftOST, DiscTexture.NETHER_UPDATE, () -> CONFIG.vanillaDrops);
    public static final Item AXOLOTL = create("axolotl", () -> CONFIG.minecraftOST, DiscTexture.UNDERWATER, () -> CONFIG.vanillaDrops);
    public static final Item DRAGON_FISH = create("dragon_fish", () -> CONFIG.minecraftOST, DiscTexture.UNDERWATER, () -> CONFIG.vanillaDrops);
    public static final Item SHUNIJI = create("shuniji", () -> CONFIG.minecraftOST, DiscTexture.UNDERWATER, () -> CONFIG.vanillaDrops);
    public static final Item LEFT_TO_BLOOM = create("left_to_bloom", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item COMFORTING_MEMORIES = create("comforting_memories", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item FLOATING_DREAM = create("floating_dream", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item ONE_MORE_DAY = create("one_more_day", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item AN_ORDINARY_DAY = create("an_ordinary_day", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item INFINITE_AMETHYST = create("infinite_amethyst", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item STAND_TALL = create("stand_tall", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);
    public static final Item WENDING = create("wending", () -> CONFIG.minecraftOST, DiscTexture.OVERWORLD_UPDATE);

    public static final Item APROPOS = create("apropos", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item EPITOMIZE = create("epitomize", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item LUMINESCENT = create("luminescent", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item VITALITY = create("vitality", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item VITALITY_VIP_EDIT = create("vitality_vip_edit", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item BRIMSTONE = create("brimstone", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item EPITOMIZE_SINNERS_VIP_EDIT = create("epitomize_sinners_vip_edit", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item EPITOMIZE_VIP_EDIT = create("epitomize_vip_edit", () -> CONFIG.helltakerOST, DiscTexture.HELLTAKER);
    public static final Item ALCHEMY = create("alchemy", () -> CONFIG.helltakerOST, DiscTexture.EXAMTAKER);
    public static final Item TITANIUM = create("titanium", () -> CONFIG.helltakerOST, DiscTexture.EXAMTAKER);

    public static final Item DAIJOUBU = create("daijoubu", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item DOKI_DOKI_LITERATURE_CLUB = create("doki_doki_literature_club", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item DREAMS_OF_LOVE_AND_LITERATURE = create("dreams_of_love_and_literature", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item I_STILL_LOVE_YOU = create("i_still_love_you", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item MY_CONFESSION = create("my_confession", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item MY_FEELINGS = create("my_feelings", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item OHAYOU_SAYORI = create("ohayou_sayori", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item OKAY_EVERYONE = create("okay_everyone", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item PLAY_WITH_ME = create("play_with_me", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item POEM_PANIC = create("poem_panic", () -> CONFIG.ddlcOST, DiscTexture.DDLC);
    public static final Item SAYO_NARA = create("sayo-nara", () -> CONFIG.ddlcOST, DiscTexture.DDLC_BROKEN);
    public static final Item YOUR_REALITY = create("your_reality", () -> CONFIG.ddlcOST, DiscTexture.DDLC);

    public static void registerItems() {
    }

    private static ExtraDiscItem create(String name, SoundEvent event, Supplier<Boolean> supplier, DiscTexture discTexture) {
        return create(name, event, supplier, discTexture, () -> true);
    }

    private static ExtraDiscItem create(String name, Supplier<Boolean> supplier, DiscTexture discTexture) {
        return create(name, supplier, discTexture, () -> true);
    }

    private static ExtraDiscItem create(String name, Supplier<Boolean> supplier, DiscTexture discTexture, Supplier<Boolean> dropsFromCreeper) {
        final Identifier id = Util.id(name);
        return create(name, new SoundEvent(id), supplier, discTexture, dropsFromCreeper);
    }

    private static ExtraDiscItem create(String name, SoundEvent event, Supplier<Boolean> supplier, DiscTexture discTexture, Supplier<Boolean> dropsFromCreeper) {
        final Identifier id = Util.id(name);
        if (supplier.get()) {
            final ExtraDiscItem item = new ExtraDiscItem(event, new FabricItemSettings().group(ExtraRecords.EXTRARECORDS_ITEM_GROUP), dropsFromCreeper.get());
            Registry.register(Registry.ITEM, id, item);
            Tags.addDisc(new Pair<>(item, id));
            ARRP.itemModel(id, discTexture);
            return item;
        }
        return null;
    }
}
