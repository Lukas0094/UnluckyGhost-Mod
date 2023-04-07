package net.lukas.unluckyghost.item;

import net.lukas.unluckyghost.UnluckyGhost;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnluckyGhost.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab UNLUCKYGHOST_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        UNLUCKYGHOST_TAB = event.registerCreativeModeTab(new ResourceLocation(UnluckyGhost.MOD_ID, "unluckyghost_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                        .title(Component.translatable("creativemodetab.unluckyghost_tab")));
    }
}
