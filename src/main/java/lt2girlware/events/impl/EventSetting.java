package lt2girlware.events.impl;

import lt2girlware.events.Event;
import lt2girlware.setting.Setting;

public class EventSetting extends Event {
    final Setting<?> setting;

    public EventSetting(Setting<?> setting){
        this.setting = setting;
    }

    public Setting<?> getSetting() {
        return setting;
    }
}
