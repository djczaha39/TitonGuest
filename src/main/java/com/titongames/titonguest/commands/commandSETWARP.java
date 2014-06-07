package com.titongames.titonguest.commands;


import com.titongames.titonguest.Main;
import com.titongames.titonguest.WarpHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandSETWARP implements CommandExecutor {
    private Main plugin;

    public commandSETWARP(Main plugin) {
        this.plugin = plugin;
    }

    WarpHandler warp = new WarpHandler(this.plugin);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;

        if(args.length < 1) {
            return false;
        } else if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You're not a player!");
            return true;
        }

        if(player.hasPermission("titonguest.admin.setwarp") || player.isOp()) {
            warp.m_warps.put(args[0], player.getLocation());
            player.sendMessage(ChatColor.GREEN + "[TitonGuest] Warp created!");
            warp.saveSettings();
            return true;
        } else {
          player.sendMessage(ChatColor.RED + "You do not have permissions to use this command.");
        }
        return true;
    }
}
