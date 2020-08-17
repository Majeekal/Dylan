package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class CarEject implements Listener {
    private Dylan instance;

    public CarEject(Dylan instance){
        this.instance = instance;
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event){
        if(event.getVehicle().getCustomName() != null && event.getVehicle().getCustomName().equals("Car")){
            event.getVehicle().remove();
        }
    }

    @EventHandler
    public void onItemDrop(EntityDropItemEvent event){
        if(event.getEntity() instanceof Minecart && event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Car")){
            event.setCancelled(true);
        }
    }
}
