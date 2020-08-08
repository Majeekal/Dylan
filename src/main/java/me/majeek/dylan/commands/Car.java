package me.majeek.dylan.commands;

import me.majeek.dylan.Dylan;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Car implements Command {
    private Dylan instance;

    public Car(Dylan instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        if(player.isInsideVehicle()){
            if(player.getVehicle().getCustomName() != null && player.getVehicle().getCustomName().equals("Car")){
                player.getVehicle().remove();
                player.sendMessage(instance.getPrefix() + " " + ChatColor.RED + "Car despawned");
                return;
            } else{
                player.getVehicle().eject();
            }
        }

        Minecart minecart = (Minecart) player.getWorld().spawnEntity(player.getLocation(), EntityType.MINECART);
        minecart.setCustomName("Car");

        minecart.addPassenger(player);
        minecart.setDerailedVelocityMod(new Vector(0.9, 0.9, 0.9));
        minecart.setMaxSpeed(5);
        minecart.setInvulnerable(true);

        player.sendMessage(instance.getPrefix() + " " + ChatColor.GREEN + "Car spawned");
    }
}
