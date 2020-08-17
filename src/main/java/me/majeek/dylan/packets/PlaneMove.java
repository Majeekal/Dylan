package me.majeek.dylan.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.majeek.dylan.Dylan;
import me.majeek.dylan.data.PlaneData;
import net.minecraft.server.v1_16_R1.PacketPlayInFlying;
import net.minecraft.server.v1_16_R1.PacketPlayInSteerVehicle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class PlaneMove extends PacketAdapter {
    private Dylan instance;

    public PlaneMove(Dylan instance, PacketType packetType) {
        super(instance, ListenerPriority.NORMAL, packetType);

        this.instance = instance;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        if(event.getPacket().getHandle() instanceof PacketPlayInSteerVehicle) {
            PacketPlayInSteerVehicle packet = (PacketPlayInSteerVehicle) event.getPacket().getHandle();
            Player player = event.getPlayer();

            if(player.isInsideVehicle() && player.getVehicle().getCustomName() != null && player.getVehicle().getCustomName().equals("Plane")){
                Horse plane = (Horse) player.getVehicle();

                if(!instance.getDataManager().getEntityData().containsKey(plane.getUniqueId())){
                    instance.getDataManager().addEntityData(plane.getUniqueId(), plane);
                    instance.getDataManager().addPlaneData(plane.getUniqueId(), new PlaneData((float) instance.getConfig().getDouble("plane-speed"), 0, player.getLocation().getDirection()));
                }

                PlaneData planeData = instance.getDataManager().getPlaneData().get(plane.getUniqueId());

                float forward = packet.c();

                if(forward > 0 && planeData.getThrottle() < 100){
                    planeData.setThrottle(planeData.getThrottle() + 1);
                    player.sendMessage(ChatColor.GREEN + "Throttle: " + ChatColor.YELLOW + planeData.getThrottle());
                } else if(forward < 0 && planeData.getThrottle() > 0){
                    planeData.setThrottle(planeData.getThrottle() - 1);
                    player.sendMessage(ChatColor.GREEN + "Throttle: " + ChatColor.YELLOW + planeData.getThrottle());
                }
            }
        } else if(event.getPacket().getHandle() instanceof PacketPlayInFlying){
            if(!(event.getPacket().getHandle() instanceof PacketPlayInFlying.PacketPlayInPosition)){
                Player player = event.getPlayer();

                if(player.isInsideVehicle() && player.getVehicle().getCustomName() != null && player.getVehicle().getCustomName().equals("Plane")){
                    HashMap<UUID, PlaneData> planeData = instance.getDataManager().getPlaneData();
                    PlaneData data = planeData.get(player.getVehicle().getUniqueId());

                    try { data.setDirection(player.getLocation().getDirection()); } catch (NullPointerException ignored){ }

                    planeData.put(player.getVehicle().getUniqueId(), data);

                    instance.getDataManager().setPlaneData(planeData);
                }
            }

            for(Entity plane : instance.getDataManager().getEntityData().values()){
                PlaneData data = instance.getDataManager().getPlaneData().get(plane.getUniqueId());

                plane.setVelocity(new Vector((data.getDirection().getX() * data.getThrottle()) * 0.025, ((data.getDirection().getY() * data.getThrottle()) * 0.025) - (2.5 * 0.0784000015258789), (data.getDirection().getZ() * data.getThrottle()) * 0.025));
            }
        }
    }
}
