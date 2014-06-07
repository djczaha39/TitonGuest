package com.titongames.titonguest;

import com.titongames.titonguest.commands.*;
import com.titongames.titonguest.listeners.ListenerPlayerConnection;
import com.titongames.titonguest.listeners.ListenerPlayerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Main extends JavaPlugin{

    public static final String PLUGIN_NAME = "TitonGuest";
    public final String FILE_WARPS = "warps.txt";
    public File m_Folder;
    public HashMap<String, Location> m_warps = new HashMap();
    static Properties prop = new Properties(); //creating properties file
    WarpHandler warp = new WarpHandler(this);

    private static Plugin plugin;

    @Override
    public void onEnable(){
        m_Folder = this.getDataFolder();
        File homelist = new File(this.m_Folder.getAbsolutePath() + File.separator + "warps.txt");
        if(!m_Folder.exists()) {
            getLogger().info("Missing Folder. Attempting to create it.");
            m_Folder.mkdir();
            getLogger().info("Done!");
        }
        if(!homelist.exists()) {
            getLogger().info("Missing Warplist, creating the file...");
            try {
                homelist.createNewFile();
                getLogger().info("Done!");
            } catch (IOException ex) {
                getLogger().info("FAILED");
            }
        }
        getLogger().info("Loading warps...");
        if(warp.loadSettings()) {
            getLogger().info("Done!");
        } else {
            getLogger().info("FAILED");
        }
        getLogger().info("Starting " + PLUGIN_NAME);
        registerEvents(this, new ListenerPlayerConnection());
        registerEvents(this, new ListenerPlayerState());
        getCommand("ttp").setExecutor(new commandTP());
        getCommand("list").setExecutor(new commandWHO(this));
        getCommand("who").setExecutor(new commandWHO(this));
        getCommand("players").setExecutor(new commandWHO(this));
        // getCommand("god").setExecutor(new commandGOD(this));
        getCommand("warp").setExecutor(new commandWARP(this));
        getCommand("warplist").setExecutor(new commandWARPLIST(this));
        getCommand("setwarp").setExecutor(new commandSETWARP(this));
        getCommand("delwarp").setExecutor(new commandDELWARP(this));
    }

    @Override
    public void onDisable(){
        getLogger().info("Disabling " + PLUGIN_NAME);
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
                    sender.sendMessage(ChatColor.AQUA + "/ttp - Titongames teleport");
                    sender.sendMessage(ChatColor.AQUA + "/who - Show online players");
                    sender.sendMessage(ChatColor.AQUA + "/god - Give you god-mode");
                    sender.sendMessage(ChatColor.RED + " ====================== ");
                }
            }
        }
        return false;
    }
}
