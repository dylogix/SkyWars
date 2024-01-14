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
			if(!p.hasPermission("skywars.setup") || p.hasPermission("skywars.*")) {
				p.sendMessage(Main.prefix + "§cYou don't have the permission to use this command!");
			} else {
				String usagemessage = Main.prefix + "Usage: /setspawn <mapname|lobby> <count>";
				
				if(args.length == 0) {
					p.sendMessage(usagemessage);
				} else {
					if(args[0].equalsIgnoreCase("lobby")) {
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

						p.sendMessage(Main.prefix + "Updated lobby spawn location.");
					} else {
						if(args.length != 2) {
							p.sendMessage(usagemessage);
						} else {
							String mapname = args[0];
							String spawncount = args[1];

							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".x", p.getLocation().getX());
							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".y", p.getLocation().getY());
							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".z", p.getLocation().getZ());
							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".yaw", p.getLocation().getYaw());
							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".pitch", p.getLocation().getPitch());
							Main.cfg.set("locations.maps." + mapname + ".spawn" + spawncount + ".world", p.getLocation().getWorld().getName());
							
							try {
								Main.cfg.save(Main.config);
							} catch (IOException e) {
								e.printStackTrace();
							}

							p.sendMessage(Main.prefix + "Saved spawn §a" + spawncount + "§7 for the map §a" + mapname + "§7.");
						}
					}
				}
			}
		}
		
		return true;
	}

}
