package com.titongames.titonguest.commands;

import com.titongames.titonguest.Main;
import com.titongames.titonguest.WarpHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandWARPLIST implements CommandExecutor {
    private Main plugin;

    public commandWARPLIST(Main plugin){
        this.plugin = plugin;
    }

    WarpHandler warp = new WarpHandler(this.plugin);

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("titonguest.warplist")) {
            String filer = args.length >= 1 ? args[0] : "";
            String[] locs = warp.getList(filer);
            if((locs != null) && (locs.length >= 1)) {
                for(String i : locs) {
                    player.sendMessage(i);
                }
            } else {
                player.sendMessage(ChatColor.RED + "No warps found!");
            }
        } else {
            player.sendMessage("You do not have permission to use this command.");
        }
    return true;
    }
}
