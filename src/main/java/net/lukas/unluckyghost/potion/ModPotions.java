package net.lukas.unluckyghost.potion;

import net.lukas.unluckyghost.UnluckyGhost;
import net.lukas.unluckyghost.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, UnluckyGhost.MOD_ID);

    public static final RegistryObject<Potion> SOUL_FREEZE_POTION = POTIONS.register("soul_freeze_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SOUL_FREEZE.get(), 100, 0)));

    public static final RegistryObject<Potion> SOUL_INVINCIBILITY_POTION = POTIONS.register("soul_invincibility_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WEAKNESS, 600, 4), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4)));

    public static final RegistryObject<Potion> SOUL_SUPER_STRENGTH_POTION = POTIONS.register("soul_super_strength_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 1), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 1)));

    public static final RegistryObject<Potion> SOUL_BOTTLE = POTIONS.register("soul_bottle",
            () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}