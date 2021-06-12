package io.github.racoondog.extrarecordscore;

import io.github.racoondog.extrarecordscore.util.Disc;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ExtrarecordsCore implements ModInitializer {
    public static final String modID = "extrarecords-core";

    public static final ItemGroup MINECRAFT_GROUP = FabricItemGroupBuilder.build(new Identifier(modID, "minecraft_group"), () -> new ItemStack(ExtrarecordsCore.KEY));

    public static final Item KEY = Disc.createDisc("key");
    public static final Item SUBWOOFER_LULLABY = Disc.createDisc("subwooferlullaby");
    public static final Item LIVING_MICE = Disc.createDisc("livingmice");
    public static final Item HAGGSTROM = Disc.createDisc("haggstrom");
    public static final Item MINECRAFT = Disc.createDisc("minecraft");
    public static final Item OXYGENE = Disc.createDisc("oxygene");
    public static final Item MICE_ON_VENUS = Disc.createDisc("miceonvenus");
    public static final Item DRY_HANDS = Disc.createDisc("dryhands");
    public static final Item WET_HANDS = Disc.createDisc("wethands");
    public static final Item CLARK = Disc.createDisc("clark");
    public static final Item SWEDEN = Disc.createDisc("sweden");
    public static final Item DANNY = Disc.createDisc("danny");
    public static final Item MOOG_CITY_2 = Disc.createDisc("moogcity2");
    public static final Item MUTATION = Disc.createDisc("mutation");
    public static final Item FLOATING_TREES = Disc.createDisc("floatingtrees");
    public static final Item BEGINNING_2 = Disc.createDisc("beginning2");
    public static final Item BLIND_SPOTS = Disc.createDisc("blindspots");
    public static final Item BIOME_FEST = Disc.createDisc("biomefest");
    public static final Item HAUNT_MUSKIE = Disc.createDisc("hauntmuskie");
    public static final Item ARIA_MATH = Disc.createDisc("ariamath");
    public static final Item TASWELL = Disc.createDisc("taswell");
    public static final Item DREITON = Disc.createDisc("dreiton");
    public static final Item DEAD_VOXEL = Disc.createDisc("deadvoxel");
    public static final Item CONCRETE_HALLS = Disc.createDisc("concretehalls");
    public static final Item WARMTH = Disc.createDisc("warmth");
    public static final Item BALLAD_OF_THE_CATS = Disc.createDisc("balladofthecats");
    public static final Item RUBEDO = Disc.createDisc("rubedo");
    public static final Item SO_BELOW = Disc.createDisc("sobelow");
    public static final Item CHRYSOPOEIA = Disc.createDisc("chrysopoeia");
    public static final Item ALPHA = Disc.createDisc("alpha", SoundEvents.MUSIC_CREDITS);
    public static final Item THE_END = Disc.createDisc("theend", SoundEvents.MUSIC_END);
    public static final Item BOSS = Disc.createDisc("boss", SoundEvents.MUSIC_DRAGON);
    public static final Item AXOLOTL = Disc.createDisc("axolotl");
    public static final Item DRAGON_FISH = Disc.createDisc("dragonfish");
    public static final Item SHUNIJI = Disc.createDisc("shuniji");

    @Override
    public void onInitialize() {}
}
