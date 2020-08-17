package me.majeek.dylan.commands;

import me.majeek.dylan.Dylan;
import me.majeek.dylan.data.PlaneData;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class Plane implements Command {
    private Dylan instance;

    public Plane(Dylan instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        if(player.isInsideVehicle()){
            if(player.getVehicle().getCustomName() != null && player.getVehicle().getCustomName().equals("Plane")){
                player.getVehicle().remove();
                player.sendMessage(instance.getPrefix() + " " + ChatColor.RED + "Plane despawned");
                return;
            } else{
                player.getVehicle().eject();
            }
        }

        Horse plane = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
        plane.setCustomName("Plane");

        plane.addPassenger(player);
        plane.setAI(false);
        plane.setInvulnerable(true);

        instance.getDataManager().addEntityData(plane.getUniqueId(), plane);
        instance.getDataManager().addPlaneData(plane.getUniqueId(), new PlaneData((float) instance.getConfig().getDouble("plane-speed"), 0, player.getLocation().getDirection()));

        player.sendMessage(instance.getPrefix() + " " + ChatColor.GREEN + "Plane spawned");
    }
}
