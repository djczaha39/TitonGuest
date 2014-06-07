package com.titongames.titonguest.commands;


import com.titongames.titonguest.Main;
import com.titongames.titonguest.WarpHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandDELWARP implements CommandExecutor{
    private Main plugin;

    public commandDELWARP(Main plugin) {
        this.plugin = plugin;
    }

    WarpHandler warp = new WarpHandler(this.plugin);

    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        throw new UnsupportedOperationException("Comming soon...");
    }
}
