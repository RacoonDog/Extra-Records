package io.github.racoondog.extrarecords.datagen;

public enum DiscTexture {
    CREATIVE("item/creative_disc"),
    END("item/end_disc"),
    NETHER("item/nether_disc"),
    NETHER_UPDATE("item/nether_update_disc"),
    NETHER_CRIMSON("item/nether_crimson_disc"),
    OVERWORLD("item/overworld_disc"),
    CAVES_AND_CLIFFS("item/caves_and_cliffs_disc"),
    MANGROVE("item/mangrove_disc"),
    DEEP_DARK("item/deep_dark_disc"),
    UNDERWATER("item/underwater_disc"),
    MENU("item/menu_disc"),
    HELLTAKER("item/helltaker_disc"),
    EXAMTAKER("item/examtaker_disc"),
    DDLC("item/ddlc_disc"),
    DDLC_BROKEN("item/ddlc_broken_disc");

    public final String textureName;

    DiscTexture(String textureName) {
        this.textureName = textureName;
    }
}
