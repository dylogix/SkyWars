package de.dylogix.skywars.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dylogix.skywars.main.Main;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(!p.isOp()) {
				p.sendMessage(Main.prefix + "You don't have the permission to use this command!");
			} else {
				if(args.length == 0) {
					p.sendMessage(Main.prefix + "Usage: /setspawn <mapname|lobby> <count>");
				} else {
					if(args[0].equalsIgnoreCase("lobby")) {
						p.sendMessage(Main.prefix + "Updated lobby spawn location.");

						Main.cfg.set("locations.lobby.x", p.getLocation().getX());
						Main.cfg.set("locations.lobby.y", p.getLocation().getY());
						Main.cfg.set("locations.lobby.z", p.getLocation().getZ());
						Main.cfg.set("locations.lobby.yaw", p.getLocation().getYaw());
						Main.cfg.set("locations.lobby.pitch", p.getLocation().getPitch());
						Main.cfg.set("locations.lobby.world", p.getLocation().getWorld().getName());
						
						try {
							Main.cfg.save(Main.config);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					} else {
						p.sendMessage(Main.prefix + "else" + args[0]);
					}
				}
			}
		}
		
		return true;
	}

}
