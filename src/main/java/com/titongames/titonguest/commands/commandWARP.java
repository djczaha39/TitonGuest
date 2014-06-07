package com.titongames.titonguest.commands;

import com.titongames.titonguest.Main;
import com.titongames.titonguest.WarpHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandWARP implements CommandExecutor {
    private Main plugin;

    public commandWARP(Main plugin) {
        this.plugin = plugin;
    }

    WarpHandler warp = new WarpHandler(this.plugin);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player) sender;

        if(player.hasPermission("titonguest.warp") || player.isOp()) {
            if(args.length < 1) {
                return false;
            } else if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You're not a player!");
                return true;
            }

            Location loc = (Location) warp.m_warps.get(args[0]);
            if(loc != null) {
                warpPlayer(player, loc);
                player.sendMessage(ChatColor.AQUA + "Woosh!");
            } else {
                player.sendMessage(ChatColor.RED + "Wrong warp name!");
            }
        } else if (!player.hasPermission("titonguest.warp")) {
            player.sendMessage(ChatColor.RED + "You do not have the permission to use this command.");
        } else {
            player.sendMessage(ChatColor.RED + "Wrong warp name!");
        }
        return true;
    }

    private void warpPlayer(Player player, Location loc) {
        Block block = loc.getBlock();
        while(block.getRelative(0, 1, 0).getTypeId() != 0 && block.getY() < 256) {
            if(block.getRelative(0, 1, 0).getTypeId() != 0) {
                block = block.getRelative(0, 3, 0);
            } else {
                block = block.getRelative(0, 2, 0);
            }
        }
        player.teleport(new Location(block.getWorld(), block.getX(), block.getX(), block.getZ(), loc.getYaw(), loc.getPitch()));
    }

}
