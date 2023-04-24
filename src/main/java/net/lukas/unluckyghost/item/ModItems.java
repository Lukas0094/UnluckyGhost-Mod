package net.lukas.unluckyghost.item;

import net.lukas.unluckyghost.UnluckyGhost;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UnluckyGhost.MOD_ID);

    public static final RegistryObject<Item> GHOST_ITEM = ITEMS.register("ghost_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CERAMIC_SHARD = ITEMS.register("ceramic_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_SHARD = ITEMS.register("iron_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIREAXE = ITEMS.register("fireaxe",
            () -> new AxeItem(Tiers.IRON, 6, -3f,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
