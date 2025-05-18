package net.wetnoodles90.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wetnoodles90.block.ModBlocks;

public class PlacerBlockEntity extends BlockEntity {
    public PlacerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.PLACER_BLOCK_ENTITY, pos, state);
    }


}
