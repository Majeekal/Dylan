package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlaneDestroy implements Listener {
    private Dylan instance;

    public PlaneDestroy(Dylan instance){
        this.instance = instance;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Plane")){
            instance.getDataManager().removeEntityData(event.getEntity().getUniqueId());
            instance.getDataManager().removePlaneData(event.getEntity().getUniqueId());
            event.getEntity().remove();
        }
    }
}
