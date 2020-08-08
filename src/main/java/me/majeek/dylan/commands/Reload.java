package me.majeek.dylan.commands;

import me.majeek.dylan.Dylan;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Reload implements Command {
    private Dylan instance;

    public Reload(Dylan instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        instance.reloadConfig();
        player.sendMessage(instance.getPrefix() + " " + ChatColor.GREEN + "Config reloaded");
    }
}
