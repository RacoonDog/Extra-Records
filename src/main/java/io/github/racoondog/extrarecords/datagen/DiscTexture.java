package io.github.racoondog.extrarecords.datagen;

public enum DiscTexture {
    CREATIVE("item/creative_disc"),
    END("item/end_disc"),
    NETHER("item/nether_disc"),
    NETHER_UPDATE("item/nether_update_disc"),
    OVERWORLD("item/overworld_disc"),
    OVERWORLD_UPDATE("item/overworld_update_disc"),
    UNDERWATER("item/underwater_disc"),
    MENU("item/menu_disc"),
    HELLTAKER("item/helltaker_disc"),
    EXAMTAKER("item/examtaker_disc"),
    DDLC("item/ddlc_disc");

    public final String textureName;

    DiscTexture(String textureName) {
        this.textureName = textureName;
    }
}
