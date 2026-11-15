package lt2girlware.features.modules.misc;

import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import lt2girlware.features.modules.Module;
import lt2girlware.setting.Setting;
import lt2girlware.utility.player.InventoryUtility;
import lt2girlware.utility.player.SearchInvResult;

public class AutoSoup extends Module {
    public AutoSoup() {
        super("AutoSoup", Category.MISC);
    }

    private final Setting<Float> health = new Setting<>("TriggerHealth", 7f, 1f, 20f);

    @Override
    public void onUpdate() {
        if (mc.player.getHealth() <= health.getValue()) {
            SearchInvResult result = InventoryUtility.findItemInHotBar(Items.MUSHROOM_STEW);
            int prevSlot = mc.player.getInventory().selectedSlot;
            if (result.found()) {
                result.switchTo();
                sendSequencedPacket(id -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, id, mc.player.getYaw(), mc.player.getPitch()));
                InventoryUtility.switchTo(prevSlot);
            }
        }
    }
}
