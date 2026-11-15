package lt2girlware.injection;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import lt2girlware.core.Managers;
import lt2girlware.core.manager.client.ModuleManager;
import lt2girlware.features.modules.combat.Aura;

import static lt2girlware.core.manager.IManager.mc;

@Mixin(FireworkRocketEntity.class)
public class MixinFireWorkEntity {

    @Shadow
    private LivingEntity shooter;

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getRotationVector()Lnet/minecraft/util/math/Vec3d;"))
    private Vec3d tickHook(LivingEntity instance) {
        if (ModuleManager.aura.isEnabled() && ModuleManager.aura.rotationMode.not(Aura.Mode.None)
                && ModuleManager.aura.target != null && shooter == mc.player && ModuleManager.aura.elytraTarget.getValue()) {

          //  float[] nonLimitedRotation = PlayerManager.calcAngle(ModuleManager.aura.target.getEyePos().add(0, 0.5, 0));
            return Managers.PLAYER.getRotationVector(ModuleManager.aura.rotationPitch, ModuleManager.aura.rotationYaw);
        }
        return shooter.getRotationVector();
    }
}
