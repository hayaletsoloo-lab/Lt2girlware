package lt2girlware.features.modules.player;

import lt2girlware.injection.accesors.ILivingEntity;
import lt2girlware.features.modules.Module;
import lt2girlware.setting.Setting;

public class NoJumpDelay extends Module {
    public NoJumpDelay() {
        super("NoJumpDelay", Category.PLAYER);
    }

    private final Setting<Integer> delay = new Setting<>("Delay", 1, 0, 4);

    @Override
    public void onUpdate() {
        if (((ILivingEntity)mc.player).getLastJumpCooldown() > delay.getValue()) {
            ((ILivingEntity)mc.player).setLastJumpCooldown(delay.getValue());
        }
    }
}
