package com.yazhal.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ConfigCommand implements CommandExecutor {
    private FirstPlugin main;
    public ConfigCommand(FirstPlugin main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            main.getConfig().set("Word", "Cake");

            List<String> list = main.getConfig().getStringList("String-list");
            list.add("New value");
            main.getConfig().set("String-list", list);

            player.sendMessage(main.getConfig().getString("Word"));
            player.sendMessage(main.getConfig().getInt("number" ) + "");

            if (main.getConfig().getBoolean("Boolean")) {
                player.sendMessage("Boolean is True");
            } else {
                player.sendMessage("Boolean is False");
            }

            for (String string : main.getConfig().getStringList("String-list")) {
                player.sendMessage(string);
            }
        }

        return false;
    }
}
