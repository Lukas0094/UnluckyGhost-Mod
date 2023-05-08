package net.lukas.unluckyghost.item;

import net.lukas.unluckyghost.UnluckyGhost;
import net.lukas.unluckyghost.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier FIREAXE;

    static {
        FIREAXE = TierSortingRegistry.registerTier(
                new ForgeTier(5, 2000, 9f, 3f, 24,
                        ModTags.Blocks.NEEDS_FIREAXE_TOOL, () -> Ingredient.of(ModItems.FIREAXE.get())),
                new ResourceLocation(UnluckyGhost.MOD_ID, "fireaxe"), List.of(Tiers.NETHERITE), List.of());
    }
}