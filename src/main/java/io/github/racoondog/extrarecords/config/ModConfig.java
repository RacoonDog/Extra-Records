package io.github.racoondog.extrarecords.config;

import io.github.racoondog.extrarecords.ExtraRecords;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = ExtraRecords.MODID)
public class ModConfig implements ConfigData {
    public boolean minecraftOST = true;
    public boolean helltakerOST = true;
}
