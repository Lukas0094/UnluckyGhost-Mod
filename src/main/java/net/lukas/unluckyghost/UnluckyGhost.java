package net.lukas.unluckyghost;

import com.mojang.logging.LogUtils;
import net.lukas.unluckyghost.block.ModBlocks;
import net.lukas.unluckyghost.effect.ModEffects;
import net.lukas.unluckyghost.enchantment.ModEnchantments;
import net.lukas.unluckyghost.item.ModCreativeModeTabs;
import net.lukas.unluckyghost.item.ModItems;
import net.lukas.unluckyghost.potion.ModPotions;
import net.lukas.unluckyghost.util.BetterBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnluckyGhost.MOD_ID)
public class UnluckyGhost
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "unluckyghost";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public UnluckyGhost()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModEnchantments.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.MAGIC_BERRY.get(), ModPotions.SOUL_BOTTLE.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SOUL_BOTTLE.get(),
                    ModItems.ICE_SHARD.get(), ModPotions.SOUL_FREEZE_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SOUL_BOTTLE.get(),
                    ModItems.SOUL_INVINCIBILITY_INGREDIENT.get(), ModPotions.SOUL_INVINCIBILITY_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.SOUL_BOTTLE.get(),
                    ModItems.SOUL_SUPER_STRENGTH_INGREDIENT.get(), ModPotions.SOUL_SUPER_STRENGTH_POTION.get()));
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTabs.UNLUCKYGHOST_TAB.get()) {
            event.accept(ModItems.GHOST_ITEM);
            event.accept(ModBlocks.RUSTY_SINK);
            event.accept(ModBlocks.GREEN_DECORATIVE_VASE);
            event.accept(ModBlocks.LIGHT_BLUE_DECORATIVE_VASE);
            event.accept(ModBlocks.PURPLE_DECORATIVE_VASE);
            event.accept(ModBlocks.YELLOW_DECORATIVE_VASE);
            event.accept(ModBlocks.LOCKER);
            event.accept(ModBlocks.EMPTYBED);
            event.accept(ModBlocks.WOODEN_BARICADE);
            event.accept(ModBlocks.PILLORY);
            event.accept(ModBlocks.GRAVESTONE);
            event.accept(ModBlocks.STRANGE_NOTES);
            event.accept(ModBlocks.GREEN_VASE);
            event.accept(ModBlocks.LIGHT_BLUE_VASE);
            event.accept(ModBlocks.PURPLE_VASE);
            event.accept(ModBlocks.YELLOW_VASE);
            event.accept(ModItems.CERAMIC_SHARD);
            event.accept(ModItems.IRON_SHARD);
            event.accept(ModItems.ICE_SHARD);
            event.accept(ModItems.FIREAXE);
            event.accept(ModItems.PHOTO_CAMERA);
            event.accept(ModItems.SOUND_RECORDER);
            event.accept(ModItems.STRANGE_SEEDS);
            event.accept(ModItems.MAGIC_BERRY);
            event.accept(ModItems.SOUL_INVINCIBILITY_INGREDIENT);
            event.accept(ModItems.SOUL_SUPER_STRENGTH_INGREDIENT);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGIC_CROP.get(), RenderType.cutout());

        }
    }
}
