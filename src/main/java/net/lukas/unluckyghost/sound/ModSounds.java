package net.lukas.unluckyghost.sound;

import net.lukas.unluckyghost.UnluckyGhost;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UnluckyGhost.MOD_ID);

    public static final RegistryObject<SoundEvent> NOTES_BREAK = registerSoundEvent("notes_break");
    public static final RegistryObject<SoundEvent> NOTES_PLACE = registerSoundEvent("notes_place");

    public static final ForgeSoundType NOTES_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.NOTES_BREAK, null, ModSounds.NOTES_PLACE, null, null);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(UnluckyGhost.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}