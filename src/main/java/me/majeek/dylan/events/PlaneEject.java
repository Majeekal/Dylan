package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class PlaneEject implements Listener {
    private Dylan instance;

    public PlaneEject(Dylan instance){
        this.instance = instance;
    }

    @EventHandler
    public void onVehicleExit(VehicleExitEvent event){
        if(event.getVehicle().getCustomName() != null && event.getVehicle().getCustomName().equals("Plane")){
            instance.getDataManager().removeEntityData(event.getVehicle().getUniqueId());
            instance.getDataManager().removePlaneData(event.getVehicle().getUniqueId());
            event.getVehicle().remove();
        }
    }
}
