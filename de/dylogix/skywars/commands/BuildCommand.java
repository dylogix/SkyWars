package de.dylogix.skywars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dylogix.skywars.main.Main;

public class BuildCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("build")) {
			if(!p.isOp()) {
				p.sendMessage(Main.prefix + "You don't have the permission to use this command!");
			} else {
				if(Main.buildoverride.contains(p)) {
					Main.buildoverride.remove(p);
					p.sendMessage(Main.prefix + "Build override disabled.");
				} else {
					Main.buildoverride.add(p);
					p.sendMessage(Main.prefix + "Build override enabled.");
				}
			}
		}
		
		return true;
	}

}
