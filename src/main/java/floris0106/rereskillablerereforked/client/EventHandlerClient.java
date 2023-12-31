package floris0106.rereskillablerereforked.client;

import floris0106.rereskillablerereforked.common.capabilities.SkillModel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraft.client.Minecraft;

public class EventHandlerClient
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onMouseClick(InputEvent.ClickInputEvent event)
    {
        if(event.isCanceled())
            return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if(player == null)
            return;

        ItemStack item = player.getMainHandItem();
        SkillModel model = SkillModel.get(player);

        if (!player.isCreative() && !model.canUseItem(player, item))
        {
            event.setCanceled(true);
        }
    }
}
