package net.lukas.unluckyghost.enchantment;

import net.lukas.unluckyghost.effect.ModEffects;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SoulFreezeEnchantment extends Enchantment {
    public SoulFreezeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level().isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();

            if(pLevel == 1) {
                if(pTarget instanceof LivingEntity)
                    ((LivingEntity)pTarget).addEffect(new MobEffectInstance(ModEffects.SOUL_FREEZE.get(), 60, 0, false, true));
            }
            if(pLevel == 2) {
                if(pTarget instanceof LivingEntity)
                    ((LivingEntity)pTarget).addEffect(new MobEffectInstance(ModEffects.SOUL_FREEZE.get(), 100, 0, false, true));
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}