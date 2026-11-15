package lt2girlware.utility.interfaces;

import net.minecraft.util.math.BlockPos;
import lt2girlware.features.modules.render.Trails;

import java.util.List;

public interface IEntity {
    List<Trails.Trail> getTrails();

    BlockPos thunderHack_Recode$getVelocityBP();
}
