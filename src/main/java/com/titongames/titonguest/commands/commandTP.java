package com.titongames.titonguest.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

public class commandTP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ttp")) {
            if(sender instanceof Player) {
                if(args != null && args.length > 0) {
                    Player player = (Player) sender;
                    List<Player> playerMatches = Bukkit.matchPlayer(args[0]);

                    if(playerMatches.size() > 1) {
                        player.sendMessage(ChatColor.RED + "Partial match");
                    } else if(playerMatches.isEmpty()) {
                        player.sendMessage(ChatColor.RED + "No matching players");
                    } else {
                        Player targetPlayer = playerMatches.get(0);
                        Location loc = targetPlayer.getLocation();

                        player.sendMessage(ChatColor.AQUA + "Woosh!");

                        if(args.length < 2) {
                            player.teleport(loc);
                        } else {
                            if(args[1].matches("me")) {
                                targetPlayer.sendMessage(ChatColor.DARK_AQUA + "Woosh!");
                                targetPlayer.teleport(player.getLocation());
                                return true;
                            }

                            for(int i = 1; i < args.length; i++) {
                                try {
                                    if(args[i].startsWith("x")) {
                                        loc.setX(loc.getX() + Double.parseDouble(args[i].replace("x", "")));
                                    } else if(args[i].startsWith("y")) {
                                        loc.setX(loc.getX() + Double.parseDouble(args[i].replace("y", "")));
                                    } else  if(args[i].startsWith("z")) {
                                        loc.setZ(loc.getZ() + Double.parseDouble(args[i].replace("z", "")));
                                    }
                                } catch(NumberFormatException e) {
                                    player.sendMessage(ChatColor.RED + "Error parsing argument *" + args[i] + "*");
                                    return true;
                                }
                            }
                            player.teleport(loc);
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Please specify the target player.");
                    return true;
                }
            } else {
                sender.sendMessage("This is a Player only command.");
            }
        }
        return false;
    }
}