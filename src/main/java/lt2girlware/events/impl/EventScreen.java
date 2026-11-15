package lt2girlware.events.impl;

import net.minecraft.client.gui.screen.Screen;
import lt2girlware.events.Event;

public class EventScreen extends Event {
    private final Screen screen;

    public EventScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
