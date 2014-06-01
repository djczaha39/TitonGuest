package com.titongames.titonguest.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class commandWHO implements CommandExecutor {

    private static Plugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("who")) {
            if(sender instanceof Player) {
                Player[] pl = plugin.getServer().getOnlinePlayers();
                sender.sendMessage(ChatColor.AQUA + "Online Players: " + ChatColor.RESET + pl);
            } else {
                sender.sendMessage("This is a Player only command.");
            }
        }
        return false;
    }
}
