package io.github.racoondog.extrarecordscore.api;

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
    private final Boolean defaultName;

    public Disc(SoundEvent sound, Settings settings, Rarity rarity, Boolean defaultName) {
        super(1, sound, settings.maxCount(1).rarity(rarity));
        this.defaultName = defaultName;
    }

    public static Disc createDisc(SoundEvent sound, Settings settings, Rarity rarity, Boolean defaultName) {
        return new Disc(sound, settings, rarity, defaultName);
    }
    public static Disc createDisc(SoundEvent sound, Settings settings, Boolean defaultName) {
        return createDisc(sound, settings, Rarity.RARE, defaultName);
    }
    public static Disc createDisc(SoundEvent sound, ItemGroup group, Rarity rarity, Boolean defaultName) {
        return createDisc(sound, new FabricItemSettings().group(group), rarity, defaultName);
    }
    public static Disc createDisc(SoundEvent sound, ItemGroup group, Boolean defaultName) {
        return createDisc(sound, new FabricItemSettings().group(group), Rarity.RARE, defaultName);
    }

    public static Disc createDisc(SoundEvent sound, Settings settings, Rarity rarity) {
        return createDisc(sound, settings, rarity, true);
    }
    public static Disc createDisc(SoundEvent sound, Settings settings) {
        return createDisc(sound, settings, Rarity.RARE, true);
    }
    public static Disc createDisc(SoundEvent sound, ItemGroup group, Rarity rarity) {
        return createDisc(sound, new FabricItemSettings().group(group), rarity, true);
    }
    public static Disc createDisc(SoundEvent sound, ItemGroup group) {
        return createDisc(sound, new FabricItemSettings().group(group), Rarity.RARE, true);
    }

    //Item and SoundEvent have different identifiers
    public static MusicDiscItem registerDisc(MusicDiscItem item, String modID, SoundEvent soundEvent, String path) {
        Registry.register(Registry.ITEM, new Identifier(modID, path), item);
        Registry.register(Registry.SOUND_EVENT, soundEvent.getId(), soundEvent);
        return item;
    }
    //Item and SoundEvent have the same identifier
    public static MusicDiscItem registerDisc(MusicDiscItem item, SoundEvent soundEvent) {
        Registry.register(Registry.ITEM, soundEvent.getId(), item);
        Registry.register(Registry.SOUND_EVENT, soundEvent.getId(), soundEvent);
        return item;
    }

    //Create and register disc/soundevent
    public static Disc create(Identifier identifier, ItemGroup group) {
        SoundEvent event = new SoundEvent(identifier);
        Disc item = createDisc(event, group);
        registerDisc(item, event);
        return item;
    }
    public static Disc create(Identifier identifier, Settings settings) {
        SoundEvent event = new SoundEvent(identifier);
        Disc item = createDisc(event, settings);
        registerDisc(item, event);
        return item;
    }

    //Uses the API's namespace
    public static Disc createDisc(String name) {
        Identifier id = new Identifier(ExtrarecordsCore.modID, name);
        SoundEvent event = new SoundEvent(id);
        Disc item = createDisc(event, ExtrarecordsCore.MINECRAFT_GROUP);
        registerDisc(item, event);
        return item;
    }
    public static Disc createDisc(String name, SoundEvent event) {
        Disc item = createDisc(event, ExtrarecordsCore.MINECRAFT_GROUP);
        Registry.register(Registry.ITEM, new Identifier(ExtrarecordsCore.modID, name), item);
        return item;
    }

    @Override
    public String getTranslationKey() {
        if (this.defaultName) {
            return "item.minecraft.music_disc_13";
        }
        return this.getOrCreateTranslationKey();
    }

    @Override
    public MutableText getDescription() {
        return new TranslatableText(this.getOrCreateTranslationKey() + ".desc");
    }
}