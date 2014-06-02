package com.titongames.titonguest.commands;

import com.titongames.titonguest.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.titongames.titonguest.listeners.ListenerPlayerState;

public class commandGOD implements CommandExecutor {
    private Main plugin;

    public commandGOD(Main plugin)
    {
        setPlugin(plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            if(sender.hasPermission("titonguest.admin.god") || sender.isOp()) {
                if(!(ListenerPlayerState.god.contains(sender.getName()))) {
                    ListenerPlayerState.god.add(sender.getName());
                    sender.sendMessage(ChatColor.DARK_AQUA + "God-Mode" + ChatColor.GREEN + " enabled!");
                } else {
                    ListenerPlayerState.god.remove(sender.getName());
                    sender.sendMessage(ChatColor.DARK_AQUA + "God-Mode" + ChatColor.RED + " disabled!");
                }
            }
        }
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
