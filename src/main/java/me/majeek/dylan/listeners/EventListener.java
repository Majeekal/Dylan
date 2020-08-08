package me.majeek.dylan.listeners;

import me.majeek.dylan.Dylan;
import me.majeek.dylan.events.Border;
import me.majeek.dylan.events.CarEject;
import me.majeek.dylan.events.CarStep;

public class EventListener implements Listener {
    private Dylan instance;

    public EventListener(Dylan instance){
        this.instance = instance;
    }

    public void register(){
        instance.getServer().getPluginManager().registerEvents(new Border(instance), instance);
        instance.getServer().getPluginManager().registerEvents(new CarEject(instance), instance);
        instance.getServer().getPluginManager().registerEvents(new CarStep(instance), instance);
    }
}
