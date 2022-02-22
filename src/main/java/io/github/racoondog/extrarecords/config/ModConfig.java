package io.github.racoondog.extrarecords.config;

import io.github.racoondog.extrarecords.ExtraRecords;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ExtraRecords.MODID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.PrefixText
    public boolean vanillaDrops = false;

    public boolean minecraftOST = true;
    public boolean helltakerOST = true;
    public boolean ddlcOST = true;
}
