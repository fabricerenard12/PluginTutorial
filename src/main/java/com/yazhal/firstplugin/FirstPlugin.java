package com.yazhal.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("Yessir!");
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("console").setExecutor(new ConsoleCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.RED + "Stop moving! You are frozen.");
    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {
        e.getPlayer().sendMessage(ChatColor.RED + "You just threw an egg!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
