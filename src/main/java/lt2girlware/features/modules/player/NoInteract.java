package lt2girlware.features.modules.player;

import lt2girlware.features.modules.Module;
import lt2girlware.setting.Setting;

public class NoInteract extends Module {
    public NoInteract() {
        super("NoInteract", Category.PLAYER);
    }

    public static Setting<Boolean> onlyAura = new Setting<>("OnlyAura", false);
}
