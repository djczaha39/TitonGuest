package com.titongames.titonguest.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class ListenerPlayerState implements Listener {

    public static List<String> god = new ArrayList();

    @EventHandler
    public void onPlayerDeath(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof Player) {
            if(god.contains(((Player) entity).getName())) {
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(false);
        }
    }



}
