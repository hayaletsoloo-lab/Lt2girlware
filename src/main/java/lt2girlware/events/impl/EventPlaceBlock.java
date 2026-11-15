package lt2girlware.events.impl;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import lt2girlware.events.Event;

public class EventPlaceBlock extends Event {
    private final BlockPos blockPos;
    private final Block block;

    public EventPlaceBlock(BlockPos blockPos, Block block) {
        this.blockPos = blockPos;
        this.block = block;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public Block getBlock() {
        return block;
    }
}
