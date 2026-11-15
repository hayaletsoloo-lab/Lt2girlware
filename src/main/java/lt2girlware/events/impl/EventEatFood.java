package lt2girlware.events.impl;

import net.minecraft.item.ItemStack;
import lt2girlware.events.Event;

public class EventEatFood extends Event {
    private final ItemStack stack;

    public EventEatFood(ItemStack stack){
        this.stack = stack;
    }

    public ItemStack getFood() {
        return stack;
    }
}
