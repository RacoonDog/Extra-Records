package io.github.racoondog.extrarecordscore.api;

import io.github.racoondog.extrarecordscore.ExtrarecordsCore;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class DiscAlt {
    /*
    Much bigger and more complicated version of Disc.
    Supports customizable max item count.
    Supports customizable name translation key/description translation key or code defined name and descriptions.
    Supports separate soundevent/item identifiers or same identifier/path.
    Supports enchantment glint, enchants and fireproof.
    ModID defaults to 'extrarecords-core'.
    Automatically registers.

    Minimum arguments:
    Item DISC = DiscAlt.create().soundEvent(soundEvent).identifier(identifier).build();
     */
    private int maxCount;
    private int comparatorOutput;
    private Item.Settings settings;
    private String path;
    private String modID = ExtrarecordsCore.modID;
    private Identifier identifier;
    private Identifier soundIdentifier;
    private Identifier itemIdentifier;
    private ItemGroup itemGroup;
    private Rarity rarity;
    private String name;
    private String customTranslationKey;
    private SoundEvent soundEvent;
    private String desc;
    private String customDescTranslationKey;
    private boolean glint = false;
    private boolean enchantable = false;
    private boolean fireproof = false;

    private DiscAlt() {
    }

    private class DiscObject extends MusicDiscItem {
        private String name;
        private String desc;
        private boolean glint;
        private boolean enchantable;
        private boolean fireproof;

        protected DiscObject(int comparatorOutput, SoundEvent sound, Settings settings, String name, String desc, boolean glint, boolean enchantable, boolean fireproof) {
            super(comparatorOutput, sound, settings);
            this.name = name;
            this.desc = desc;
            this.glint = glint;
            this.enchantable = enchantable;
            this.fireproof = fireproof;
        }

        @Override
        public String getTranslationKey() {
            if (this.name == null) {
                return "item.minecraft.music_disc_13";
            } else {
                return this.name;
            }
        }

        @Override
        public MutableText getDescription() {
            if (this.desc == null) {
                return new TranslatableText(this.getOrCreateTranslationKey() + ".desc");
            }
            return new TranslatableText(this.desc);
        }

        @Override
        public boolean hasGlint(ItemStack stack) {
            return glint;
        }

        @Override
        public boolean isEnchantable(ItemStack stack) {
            return this.enchantable;
        }

        @Override
        public boolean isFireproof() {
            return this.fireproof;
        }
    }

    public static DiscAlt create() {
        return new DiscAlt();
    }

    public DiscAlt maxCount(int maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    public DiscAlt comparatorOutput(int comparatorOutput) {
        if (comparatorOutput < 16) {
            this.comparatorOutput = comparatorOutput;
        }
        return this;
    }

    public DiscAlt settings(Item.Settings settings) {
        this.settings = settings;
        return this;
    }

    //Same soundevent and item path, requires modID
    public DiscAlt path(String path) {
        this.path = path;
        return this;
    }

    //Same soundevent and item identifier
    public DiscAlt identifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public DiscAlt soundIdentifier(Identifier soundIdentifier) {
        this.soundIdentifier = soundIdentifier;
        return this;
    }

    public DiscAlt itemIdentifier(Identifier itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
        return this;
    }

    public DiscAlt itemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }

    public DiscAlt rarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public DiscAlt name(String name) {
        this.name = name;
        return this;
    }

    public DiscAlt customTranslationKey(String customTranslationKey) {
        this.customTranslationKey = customTranslationKey;
        return this;
    }

    public DiscAlt soundEvent(SoundEvent soundEvent) {
        this.soundEvent = soundEvent;
        return this;
    }

    public DiscAlt desc(String desc) {
        this.desc = desc;
        return this;
    }

    public DiscAlt customDescTranslationKey(String customDescTranslationKey) {
        this.customDescTranslationKey = customDescTranslationKey;
        return this;
    }

    public DiscAlt modID(String modID) {
        this.modID = modID;
        return this;
    }

    public DiscAlt glint(boolean glint) {
        this.glint = glint;
        return this;
    }

    public DiscAlt enchantable(boolean enchantable) {
        this.enchantable = enchantable;
        return this;
    }

    public DiscAlt fireproof(boolean fireproof) {
        this.fireproof = fireproof;
        return this;
    }

    public DiscObject build() {
        if (this.maxCount == 0) {
            this.maxCount = 1;
        }
        if (this.comparatorOutput == 0) {
            this.comparatorOutput = 1;
        }
        if (this.rarity == null) {
            this.rarity = Rarity.RARE;
        }
        if (this.settings == null) {
            if (this.itemGroup == null) {
                this.settings = new FabricItemSettings().group(ItemGroup.MISC);
            } else {
                this.settings = new FabricItemSettings().group(this.itemGroup);
            }
            this.settings.rarity(this.rarity).maxCount(this.maxCount);
        }
        if (this.identifier == null) {
            if (this.itemIdentifier == null) {
                if (modID == null) {
                    System.err.println("No identifier/modID specified for music disc");
                }
                if (this.path == null) {
                    System.err.println("No path/identifier specified for music disc");
                }
                this.itemIdentifier = new Identifier(modID, this.path);
            }
            if (this.soundIdentifier == null) {
                if (modID == null) {
                    System.err.println("No identifier/modID specified for music disc");
                }
                if (this.path == null) {
                    System.err.println("No path/identifier specified for music disc");
                }
                this.soundIdentifier = new Identifier(modID, this.path);
            }
        } else {
            this.itemIdentifier = this.identifier;
            this.soundIdentifier = this.identifier;
        }
        if (this.soundEvent == null) {
            this.soundEvent = new SoundEvent(this.soundIdentifier);
        }
        if (this.customTranslationKey != null) {
            this.name = customTranslationKey;
        }
        if (this.customDescTranslationKey != null) {
            this.desc = this.customDescTranslationKey;
        }
        DiscObject item = new DiscObject(this.comparatorOutput, this.soundEvent, this.settings, this.name, this.desc, this.glint, this.enchantable, this.fireproof);
        Registry.register(Registry.ITEM, this.itemIdentifier, item);
        Registry.register(Registry.SOUND_EVENT, this.soundIdentifier, this.soundEvent);
        return item;
    }
}