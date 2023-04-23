package net.lukas.unluckyghost.block;

import net.lukas.unluckyghost.UnluckyGhost;
import net.lukas.unluckyghost.block.custom.*;
import net.lukas.unluckyghost.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnluckyGhost.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WOODEN_BARICADE = registerBlock("wooden_baricade",
            () -> new WoodenBaricadeBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> RUSTY_SINK = registerBlock("rusty_sink",
            () -> new RustySinkBlock(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> STRANGE_NOTES = registerBlock("strange_notes",
            () -> new StrangeNotesBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0f).noOcclusion()));

    public static final RegistryObject<Block> LOCKER = registerBlock("locker",
            () -> new LockerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).noOcclusion()));

    public static final RegistryObject<Block> EMPTYBED = registerBlock("empty_bed",
            () -> new EmptyBedBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).noOcclusion()));
    

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
