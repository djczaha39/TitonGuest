package com.titongames.titonguest;

import com.titongames.titonguest.commands.commandTP;
import com.titongames.titonguest.commands.commandWHO;
import com.titongames.titonguest.listeners.ListenerPlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    public static final String PLUGIN_NAME = "TitonGuest";

    private static Plugin plugin;

    @Override
    public void onEnable(){
        getLogger().info("[Starting] " + PLUGIN_NAME);
        registerEvents(this, new ListenerPlayerConnection());
        getCommand("ttp").setExecutor(new commandTP());
        getCommand("who").setExecutor(new commandWHO());
    }

    @Override
    public void onDisable(){
        getLogger().info("[Disabling] " + PLUGIN_NAME);
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


    public static Plugin getPlugin() {
        return plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("titonguest")) {
            if(sender instanceof Player) {
                if(args.length == 0) {
                    //Display Help For TitonGuest
                    sender.sendMessage(ChatColor.RED + " ====== TitonGuest ====== ");
                    sender.sendMessage(ChatColor.AQUA + "/ttp - Titongames teleport.");
                    sender.sendMessage(ChatColor.AQUA + "/who - Show online players");
                    sender.sendMessage(ChatColor.AQUA + "/cmd - cmd");
                    sender.sendMessage(ChatColor.RED + " ====================== ");
                }
            }
        }
        return false;
    }
}
