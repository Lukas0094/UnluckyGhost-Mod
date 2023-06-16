package net.lukas.unluckyghost.block;

import net.lukas.unluckyghost.UnluckyGhost;
import net.lukas.unluckyghost.block.custom.*;
import net.lukas.unluckyghost.item.ModItems;
import net.lukas.unluckyghost.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnluckyGhost.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WOODEN_BARICADE = registerBlock("wooden_baricade",
            () -> new WoodenBaricadeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> RUSTY_SINK = registerBlock("rusty_sink",
            () -> new RustySinkBlock(BlockBehaviour.Properties.of()
                    .strength(4f).noOcclusion()));

    public static final RegistryObject<Block> STRANGE_NOTES = registerBlock("strange_notes",
            () -> new StrangeNotesBlock(BlockBehaviour.Properties.of().noParticlesOnBreak().sound(ModSounds.STRANGE_NOTES_SOUNDS)
                    .strength(0f).noOcclusion()));

    public static final RegistryObject<Block> LOCKER = registerBlock("locker",
            () -> new LockerBlock(BlockBehaviour.Properties.of()
                    .strength(3f).noOcclusion()));

    public static final RegistryObject<Block> EMPTY_BED = registerBlock("empty_bed",
            () -> new EmptyBedBlock(BlockBehaviour.Properties.of()
                    .strength(3f).noOcclusion()));

    public static final RegistryObject<Block> GRAVESTONE = registerBlock("gravestone",
            () -> new GravestoneBlock(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> PURPLE_VASE = registerBlock("purple_vase",
            () -> new PurpleVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> GREEN_VASE = registerBlock("green_vase",
            () -> new GreenVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> LIGHT_BLUE_VASE = registerBlock("light_blue_vase",
            () -> new LightBlueVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> YELLOW_VASE = registerBlock("yellow_vase",
            () -> new YellowVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> PURPLE_DECORATIVE_VASE = registerBlock("purple_decorative_vase",
            () -> new PurpleDecorativeVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> GREEN_DECORATIVE_VASE = registerBlock("green_decorative_vase",
            () -> new GreenDecorativeVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> LIGHT_BLUE_DECORATIVE_VASE = registerBlock("light_blue_decorative_vase",
            () -> new LightBlueDecorativeVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> YELLOW_DECORATIVE_VASE = registerBlock("yellow_decorative_vase",
            () -> new YellowDecorativeVaseBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).noOcclusion()));

    public static final RegistryObject<Block> PILLORY = registerBlock("pillory",
            () -> new PilloryBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f).noOcclusion()));

    public static final RegistryObject<Block> MAGIC_CROP = BLOCKS.register("magic_crop",
            () -> new MagicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


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
