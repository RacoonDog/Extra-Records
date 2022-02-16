package io.github.racoondog.extrarecords.datagen;

import io.github.racoondog.extrarecords.ExtraRecords;
import io.github.racoondog.extrarecords.Util;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.util.Identifier;

import static io.github.racoondog.extrarecords.ExtraRecords.RRP;

public class ARRP {
    public static void itemModel(Identifier identifier, DiscTexture texture) {
        final Identifier prefixed = Util.prefixPath(identifier, "item");
        final Identifier textureId = new Identifier(ExtraRecords.MODID, texture.textureName);
        RRP.addModel(JModel.model("item/generated").textures(JModel.textures().layer0(textureId.toString())), prefixed);
    }
}
