package de.dylogix.skywars.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dylogix.skywars.enums.GameState;
import de.dylogix.skywars.main.Main;
import de.dylogix.skywars.methods.GameStateHandler;

public class StartCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("start")) {
			if(p.hasPermission("skywars.start") || p.hasPermission("skywars.*")) {
				if(Main.gs == GameState.LOBBY) {
					if(!Bukkit.getScheduler().isCurrentlyRunning(GameStateHandler.lobby_countdown)){
						if(GameStateHandler.lobby_counter > 6) {
							GameStateHandler.lobby_counter = 6;
							p.sendMessage(Main.prefix + "§7Countdown skipped.");
						} else {
							p.sendMessage(Main.prefix + "§cThe countdown is already lower than 5 seconds.");
						}
					} else {
						p.sendMessage(Main.prefix + "§cThere aren't enough players online to start a game.");
					}
				} else {
					p.sendMessage(Main.prefix + "§cThe game is already running.");
				}
			} else {
				p.sendMessage(Main.prefix + "§cYou don't have the permission to use this command!");
			}
		}
		return true;
	}

	
}
