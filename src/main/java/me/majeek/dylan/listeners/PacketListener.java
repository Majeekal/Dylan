package me.majeek.dylan.listeners;

import com.comphenix.protocol.PacketType;
import me.majeek.dylan.Dylan;
import me.majeek.dylan.packets.CarMove;
import me.majeek.dylan.packets.PlaneMove;

public class PacketListener implements Listener {
    private Dylan instance;

    public PacketListener(Dylan instance){
        this.instance = instance;
    }

    public void register() {
        instance.getProtocolManager().addPacketListener(new CarMove(instance, PacketType.Play.Client.STEER_VEHICLE));
        instance.getProtocolManager().addPacketListener(new PlaneMove(instance, PacketType.Play.Client.STEER_VEHICLE));
        instance.getProtocolManager().addPacketListener(new PlaneMove(instance, PacketType.Play.Client.LOOK));
        instance.getProtocolManager().addPacketListener(new PlaneMove(instance, PacketType.Play.Client.POSITION));
        instance.getProtocolManager().addPacketListener(new PlaneMove(instance, PacketType.Play.Client.POSITION_LOOK));
    }
}
