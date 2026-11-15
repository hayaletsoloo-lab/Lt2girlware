package lt2girlware.features.modules.movement;

import net.minecraft.client.util.math.MatrixStack;
import lt2girlware.features.modules.Module;
import lt2girlware.setting.Setting;

public class Parkour extends Module {
    public Parkour() {
        super("Parkour", Category.MOVEMENT);
    }

    private final Setting<Float> jumpFactor = new Setting<>("JumpFactor", 0.01f, 0.001f, 0.3f);

    private final lt2girlware.utility.Timer delay = new lt2girlware.utility.Timer();

    public void onRender3D(MatrixStack stack) {
        if (mc.player.isOnGround()
                && !mc.options.jumpKey.isPressed()
                && !mc.world.getBlockCollisions(mc.player, mc.player.getBoundingBox().expand(-jumpFactor.getValue(), 0, -jumpFactor.getValue()).offset(0, -0.99, 0)).iterator().hasNext()
                && delay.every(150))
            mc.player.jump();
    }
}
