package io.github.racoondog.extrarecords.mixin.client;

import io.github.racoondog.extrarecords.ExtraRecords;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.AudioStream;
import net.minecraft.client.sound.OggAudioStream;
import net.minecraft.client.sound.RepeatingAudioStream;
import net.minecraft.client.sound.SoundLoader;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Environment(EnvType.CLIENT)
@Mixin(SoundLoader.class)
public abstract class SoundLoaderMixin {
    @Shadow @Final private ResourceManager resourceManager;

    @Inject(method = "loadStreamed", at = @At("HEAD"), cancellable = true)
    private void injectLoadStreamed(Identifier id, boolean repeatInstantly, CallbackInfoReturnable<CompletableFuture<AudioStream>> cir) {
        if (!id.getNamespace().equals(ExtraRecords.MODID) || !id.getPath().endsWith(".bz2")) return;

        cir.setReturnValue(CompletableFuture.supplyAsync(() -> {
            try {
                Resource resource = this.resourceManager.getResourceOrThrow(id);
                InputStream inputStream = new BZip2CompressorInputStream(resource.getInputStream());
                return repeatInstantly ? new RepeatingAudioStream(OggAudioStream::new, inputStream) : new OggAudioStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new CompletionException(e);
            }
        }, Util.getMainWorkerExecutor()));
    }
}
