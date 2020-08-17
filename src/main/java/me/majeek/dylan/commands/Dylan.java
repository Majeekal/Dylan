package me.majeek.dylan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dylan implements CommandExecutor {
    private me.majeek.dylan.Dylan instance;

    public Dylan(me.majeek.dylan.Dylan instance){
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0 || args[0].equalsIgnoreCase("help")){
                new Help(instance).execute(player);
            } else if(args[0].equalsIgnoreCase("car")){
                new Car(instance).execute(player);
            } else if(args[0].equalsIgnoreCase("plane")){
                new Plane(instance).execute(player);
            } else if(args[0].equalsIgnoreCase("reload")){
                new Reload(instance).execute(player);
            }
        }
        return false;
    }
}
