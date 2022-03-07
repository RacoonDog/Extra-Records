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
}
