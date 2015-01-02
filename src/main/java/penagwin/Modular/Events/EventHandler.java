package penagwin.Modular.Events;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

/**
 * Created by Penagwin on 12/30/2014.
 */
public class EventHandler {

    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(EntityJoinWorldEvent event){
        if(event.entity instanceof EntityItem ){
            EntityItem entity = (EntityItem) event.entity;

            if(entity.worldObj.isRemote)
            System.out.println(entity.getEntityItem().getDisplayName());
        }
    }
}
