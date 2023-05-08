package net.lukas.unluckyghost.item.client;

import net.lukas.unluckyghost.item.custom.SoundRecorder;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SoundRecorderRenderer extends GeoItemRenderer<SoundRecorder> {
    public SoundRecorderRenderer() {
        super(new SoundRecorderModel());
    }
}