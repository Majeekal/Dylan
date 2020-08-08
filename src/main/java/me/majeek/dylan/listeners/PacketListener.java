package me.majeek.dylan.listeners;

import com.comphenix.protocol.PacketType;
import me.majeek.dylan.Dylan;
import me.majeek.dylan.packets.CarMove;

public class PacketListener implements Listener {
    private Dylan instance;

    public PacketListener(Dylan instance){
        this.instance = instance;
    }

    public void register() {
        instance.getProtocolManager().addPacketListener(new CarMove(instance, PacketType.Play.Client.STEER_VEHICLE));
    }
}
