package com.titongames.titonguest.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ListenerPlayerConnection implements Listener {
    /**
    @EventHandler(priority= EventPriority.MONITOR)
    public void onPlayerJoin(PlayerLoginEvent event)
    {
        String player = event.getPlayer().getDisplayName();
        event.setJoinMessage(ChatColor.DARK_GRAY + "+ " + " Player " + player + " " + "has joined the game!");
    }**/

    @EventHandler(priority=EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        String player = event.getPlayer().getDisplayName();
        event.setQuitMessage(ChatColor.DARK_GRAY + "- " + "Player " + player + " " + "has left the game!");
    }
}
