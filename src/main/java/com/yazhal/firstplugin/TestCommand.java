package com.yazhal.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.hasPermission("firstplugin.use")) {
                player.sendMessage("You have permission to use this command!");
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("hello")) {
                        player.sendMessage("Hello my friend");
                        return true;
                    }
                }
            } else {
                player.sendMessage("You don't have permission to use this command.");
            }


        }
        return false;
    }
}
