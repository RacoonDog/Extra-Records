package io.github.racoondog.extrarecords.util;

import io.github.racoondog.extrarecords.ExtraRecords;
import net.minecraft.util.Identifier;

public class Util {
    public static Identifier prefixPath(Identifier identifier, String prefix) {
        return new Identifier(identifier.getNamespace(), prefix + "/" + identifier.getPath());
    }

    public static Identifier id(String path) {
        return new Identifier(ExtraRecords.MODID, path);
    }

    public static String formatDuration(int duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;
        StringBuilder sb = new StringBuilder();
        if (minutes > 0) sb.append(minutes).append('m');
        if (seconds < 10) sb.append('0');
        sb.append(seconds).append('s');
        return sb.toString();
    }
}
