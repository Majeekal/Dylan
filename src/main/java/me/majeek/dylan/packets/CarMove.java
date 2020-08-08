package me.majeek.dylan.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.majeek.dylan.Dylan;
import net.minecraft.server.v1_16_R1.PacketPlayInEntityAction;
import net.minecraft.server.v1_16_R1.PacketPlayInSteerVehicle;
import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CarMove extends PacketAdapter {
    private Dylan instance;

    private float speed;

    public CarMove(Dylan instance, PacketType packetType) {
        super(instance, ListenerPriority.NORMAL, packetType);

        this.instance = instance;
        this.speed = (float) instance.getConfig().getDouble("car-speed");
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        // Movement
        if(event.getPacket().getHandle() instanceof PacketPlayInSteerVehicle) {
            PacketPlayInSteerVehicle packet = (PacketPlayInSteerVehicle) event.getPacket().getHandle();
            Player player = event.getPlayer();

            if (player.isInsideVehicle() && player.getVehicle().getCustomName() != null && player.getVehicle().getCustomName().equals("Car")) {
                this.speed = (float) instance.getConfig().getDouble("car-speed");

                Minecart minecart = (Minecart) player.getVehicle();

                Location location = player.getLocation();
                float forward = packet.c();
                float horizontal = packet.b();

                if (forward == 0 && horizontal == 0) {
                    return;
                } else if (forward > 0 && horizontal == 0) {
                    location.setYaw(location.getYaw());
                } else if (forward < 0 && horizontal == 0) {
                    location.setYaw(location.getYaw() - 180);
                } else if (forward == 0 && horizontal > 0) {
                    location.setYaw(location.getYaw() - 90);
                } else if (forward == 0 && horizontal < 0) {
                    location.setYaw(location.getYaw() + 90);
                } else if (forward > 0 && horizontal > 0) {
                    location.setYaw(location.getYaw() - 45);
                } else if (forward > 0 && horizontal < 0) {
                    location.setYaw(location.getYaw() + 45);
                } else if (forward < 0 && horizontal > 0) {
                    location.setYaw(location.getYaw() - 135);
                } else if (forward < 0 && horizontal < 0) {
                    location.setYaw(location.getYaw() + 135);
                }

                minecart.setVelocity(new Vector((location.getDirection().getX() / 10) * speed, minecart.getVelocity().getY(), (location.getDirection().getZ() / 10) * speed));
            }
        }

        // Else if minecart is sprinting?????
    }
}
