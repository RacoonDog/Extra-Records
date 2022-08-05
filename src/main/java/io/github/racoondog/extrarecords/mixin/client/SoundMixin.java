package io.github.racoondog.extrarecords.mixin.client;

import io.github.racoondog.extrarecords.ExtraRecords;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.Sound;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(Sound.class)
public abstract class SoundMixin {
    @Shadow @Final private Identifier id;

    @Inject(method = "getLocation", at = @At("HEAD"), cancellable = true)
    private void injectGetLocation(CallbackInfoReturnable<Identifier> cir) {
        if (id.getNamespace().equals(ExtraRecords.MODID) && id.getPath().endsWith(".bz2")) cir.setReturnValue(new Identifier(id.getNamespace(), "sounds/" + id.getPath()));
    }
}
