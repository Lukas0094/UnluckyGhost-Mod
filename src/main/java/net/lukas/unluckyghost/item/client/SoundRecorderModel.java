package net.lukas.unluckyghost.item.client;

import net.lukas.unluckyghost.UnluckyGhost;
import net.lukas.unluckyghost.item.custom.SoundRecorder;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SoundRecorderModel extends GeoModel<SoundRecorder> {
    @Override
    public ResourceLocation getModelResource(SoundRecorder animatable) {
        return new ResourceLocation(UnluckyGhost.MOD_ID, "geo/sound_recorder.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoundRecorder animatable) {
        return new ResourceLocation(UnluckyGhost.MOD_ID, "textures/item/sound_recorder.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoundRecorder animatable) {
        return new ResourceLocation(UnluckyGhost.MOD_ID, "animations/sound_recorder.animation.json");
    }
}