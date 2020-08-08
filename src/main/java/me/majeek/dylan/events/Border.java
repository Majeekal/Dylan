package me.majeek.dylan.events;

import me.majeek.dylan.Dylan;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Border implements Listener {
    private Dylan instance;
    private Vector border;
    private boolean enabled;

    public Border(Dylan instance){
        this.instance = instance;
        border = new Vector(1884, 65, -808);
        enabled = true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Vector to = new Vector(event.getTo().getBlockX(), event.getTo().getBlockY(), event.getTo().getBlockZ());
        List<Color> colors = Arrays.asList(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW);

        if(!enabled && !to.equals(border)){
            enabled = true;
        } else if(enabled && to.equals(border)){
            enabled = false;

            player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cW&6e&el&ac&bo&1m&5e &ct&6o &et&ah&be &1P&5a&cr&6k&e!"), "", 20, 100, 20);

            new BukkitRunnable() {
                int count = 0;
                @Override
                public void run() {
                    if(count >= 12){
                        cancel();
                    } else{
                        List<Location> locations = Arrays.asList(new Location(player.getWorld(), 1891, 80, -809), new Location(player.getWorld(), 1864, 75, -803), new Location(player.getWorld(), 1864, 75, -816));

                        for(Location location : locations) {
                            Color random = colors.get(new Random().nextInt(colors.size()));

                            Firework firework = (Firework) player.getWorld().spawnEntity(location, EntityType.FIREWORK);
                            FireworkMeta meta = firework.getFireworkMeta();

                            meta.setPower(2);
                            meta.addEffect(FireworkEffect.builder().withColor(random).flicker(true).build());

                            firework.setFireworkMeta(meta);
                            firework.detonate();
                        }

                        count++;
                    }
                }
            }.runTaskTimer(instance, 0, 10L);
        }
    }
}
