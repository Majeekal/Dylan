package me.majeek.dylan;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.majeek.dylan.listeners.CommandListener;
import me.majeek.dylan.listeners.EventListener;
import me.majeek.dylan.listeners.PacketListener;
import me.majeek.dylan.managers.DataManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dylan extends JavaPlugin {
    private Dylan instance;
    private String prefix;

    private DataManager dataManager;
    private ProtocolManager protocolManager;

    private CommandListener commandListener;
    private EventListener eventListener;
    private PacketListener packetListener;
    
    @Override
    public void onEnable() {
        instance = this;
        prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "Dylan" + ChatColor.GRAY + "]";

        // Configs
        saveDefaultConfig();

        // Managers
        dataManager = new DataManager(instance);
        protocolManager = ProtocolLibrary.getProtocolManager();

        // Listeners
        commandListener = new CommandListener(this);
        eventListener = new EventListener(this);
        packetListener = new PacketListener(this);

        // Register Listeners
        commandListener.register();
        eventListener.register();
        packetListener.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Dylan getInstance(){
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public CommandListener getCommandListener() {
        return commandListener;
    }

    public EventListener getEventListener() {
        return eventListener;
    }

    public PacketListener getPacketListener() {
        return packetListener;
    }
}
