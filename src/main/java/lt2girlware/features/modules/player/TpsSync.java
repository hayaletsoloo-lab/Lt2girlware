package lt2girlware.features.modules.player;

import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.EventPriority;
import lt2girlware.Lt2Girlware;
import lt2girlware.core.Managers;
import lt2girlware.core.manager.client.ModuleManager;
import lt2girlware.events.impl.EventTick;
import lt2girlware.features.modules.Module;

public class TpsSync extends Module {
    public TpsSync() {
        super("TpsSync", Module.Category.PLAYER);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTick(EventTick e) {
        if (ModuleManager.timer.isEnabled()) return;
        if (Managers.SERVER.getTPS() > 1)
            Lt2Girlware.TICK_TIMER = Managers.SERVER.getTPS() / 20f;
        else Lt2Girlware.TICK_TIMER = 1f;
    }

    @Override
    public void onDisable() {
        Lt2Girlware.TICK_TIMER = 1f;
    }
}
