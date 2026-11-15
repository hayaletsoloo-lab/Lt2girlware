package lt2girlware.events.impl;

import net.minecraft.util.math.BlockPos;
import lt2girlware.events.Event;

public class EventBreakBlock extends Event {
    private BlockPos bp;

    public EventBreakBlock(BlockPos bp) {
        this.bp = bp;
    }

    public BlockPos getPos() {
        return bp;
    }
}
