package me.majeek.dylan.listeners;

import me.majeek.dylan.Dylan;

public class CommandListener implements Listener {
    private Dylan instance;

    public CommandListener(Dylan instance){
        this.instance = instance;
    }

    public void register(){
        instance.getCommand("dylan").setExecutor(new me.majeek.dylan.commands.Dylan(instance));
    }
}
