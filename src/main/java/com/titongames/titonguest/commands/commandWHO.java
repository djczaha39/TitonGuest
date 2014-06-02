package com.titongames.titonguest.commands;

import com.titongames.titonguest.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandWHO implements CommandExecutor {
    private Main plugin;

    public commandWHO(Main plugin)
    {
        setPlugin(plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length != 0)
        {
            sender.sendMessage(ChatColor.YELLOW + "Too many arguments.");
            return true;
        }
        Player[] players = Bukkit.getOnlinePlayers();
        String list = "";
        int playerCount = 0;
        for (int i = 0; i < players.length; i++)
        {
            if ((sender instanceof Player))
            {
                if (((Player)sender).canSee(players[i]))
                {
                    list = list + players[i].getDisplayName() + ChatColor.WHITE + ", ";
                    playerCount++;
                }
            }
            else
            {
                list = list + players[i].getDisplayName() + ChatColor.WHITE + ", ";
                playerCount++;
            }
        }
        if (players.length == 0)
        {
            sender.sendMessage(ChatColor.YELLOW + "No players online.");
            return true;
        }
        sender.sendMessage(ChatColor.DARK_GRAY + "Online Players (" + playerCount + "): " + ChatColor.WHITE + list.substring(0, list.length() - 2));
        return true;
    }

    public Main getPlugin()
    {
        return this.plugin;
    }

    public void setPlugin(Main plugin)
    {
        this.plugin = plugin;
    }
}
