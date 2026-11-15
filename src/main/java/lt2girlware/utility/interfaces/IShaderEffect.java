package lt2girlware.utility.interfaces;

import net.minecraft.client.gl.Framebuffer;

public interface IShaderEffect {
    void addFakeTargetHook(String name, Framebuffer buffer);
}
