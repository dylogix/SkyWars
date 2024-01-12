package de.dylogix.skywars.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dylogix.skywars.main.Main;
import de.dylogix.skywars.methods.GameStateHandler;
import de.dylogix.skywars.methods.LocationHandler;

public class TestCommand implements CommandExecutor {
	
	// command simply for testing

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("test")) {
			p.sendMessage(Main.prefix + "Command received");
			
			if(args[0].equalsIgnoreCase("lobby")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					LocationHandler.teleportPlayerToLobby(all);
				}
			} else if(args[0].equalsIgnoreCase("start")) {
				p.sendMessage(Main.prefix + "Lobby countdown started!");
				GameStateHandler.startLobbyCountdown();
			}
		}
		return true;
	}
}
