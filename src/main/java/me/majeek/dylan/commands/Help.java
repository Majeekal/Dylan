package me.majeek.dylan.commands;

import me.majeek.dylan.Dylan;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help implements Command {
    private Dylan instance;

    public Help(Dylan instance){
        this.instance = instance;
    }

    public void execute(Player player) {
        player.sendMessage(ChatColor.GRAY + "--------------" + " [ " + ChatColor.RESET + ChatColor.GREEN + "Dylans Plugin" + ChatColor.GRAY + " ] " + "-------------------");
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/dylan help" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Displays this.");
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/dylan car" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Spawns or despawns a car.");
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.GREEN + "/dylan reload" + ChatColor.WHITE + " - " + ChatColor.GRAY + "Reloads the config file.");
    }
}
