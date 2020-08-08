package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class CarEject implements Listener {
    private Dylan instance;

    public CarEject(Dylan instance){
        this.instance = instance;
    }

    @EventHandler
    public void onVehicleExit(VehicleExitEvent event){
        if(event.getVehicle().getCustomName() != null && event.getVehicle().getCustomName().equals("Car")){
            event.getVehicle().remove();
        }
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event){
        if(event.getVehicle().getCustomName() != null && event.getVehicle().getCustomName().equals("Car")){
            event.getVehicle().remove();
        }
    }
}
