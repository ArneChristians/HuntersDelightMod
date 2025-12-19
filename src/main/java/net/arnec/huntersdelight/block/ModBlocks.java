package net.arnec.huntersdelight.block;

import net.arnec.huntersdelight.HuntersDelightMod;
import net.arnec.huntersdelight.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HuntersDelightMod.MOD_ID);

    //Ore Blocks
    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 2),
                    BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 2),
                    BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops()));

    //Blocks
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> COMPRESSED_SALT_BLOCK = registerBlock("compressed_salt_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));



    private static <T extends  Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
