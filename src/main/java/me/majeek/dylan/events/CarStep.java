package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.util.Vector;

public class CarStep implements Listener {
    private Dylan instance;

    public CarStep(Dylan instance){
        this.instance = instance;
    }

    @EventHandler
    public void onBlockCollision(VehicleBlockCollisionEvent event){
        if(event.getVehicle().getCustomName() != null && event.getVehicle().getCustomName().equals("Car")){
            if((event.getBlock().getBoundingBox().getMaxY() - event.getVehicle().getLocation().getY() <= 0.5 && event.getBlock().getBoundingBox().getMaxY() - event.getVehicle().getLocation().getY() > 0) || event.getBlock().getBlockData() instanceof Stairs){
                Minecart minecart = (Minecart) event.getVehicle();
                Vector velocity = minecart.getVelocity();

                velocity.setY(event.getBlock().getBoundingBox().getHeight() / 2.5);

                minecart.setVelocity(velocity);
            }
        }
    }
}
