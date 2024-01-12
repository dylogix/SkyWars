package de.dylogix.skywars.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.dylogix.skywars.main.Main;

public class LocationHandler {
	
	public static void teleportPlayerToLobby(Player p) {
		if(Main.cfg.contains("locations.lobby")) {
			float x = (float) Main.cfg.getDouble("locations.lobby.x");
			float y = (float) Main.cfg.getDouble("locations.lobby.y");
			float z = (float) Main.cfg.getDouble("locations.lobby.z");
			float yaw = (float) Main.cfg.getDouble("locations.lobby.yaw");
			float pitch = (float) Main.cfg.getDouble("locations.lobby.pitch");
			String world = Main.cfg.getString("locations.lobby.world");
			
			Location loc = new Location(Bukkit.getWorld(world), x, y, z);
			loc.setYaw(yaw);
			loc.setPitch(pitch);
			
			p.teleport(loc);
		}
	}

	public static void teleportPlayerToSpecSpawn(Player p) {
		
	}
	
	public static void teleportAllPlayersToMap() {
		int i = 1;
		for(Player all : Bukkit.getOnlinePlayers()){
			
			if(Main.cfg.contains("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i)) {
				float x = (float) Main.cfg.getDouble("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".x");
				float y = (float) Main.cfg.getDouble("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".y");
				float z = (float) Main.cfg.getDouble("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".z");
				float yaw = (float) Main.cfg.getDouble("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".yaw");
				float pitch = (float) Main.cfg.getDouble("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".pitch");
				String world = Main.cfg.getString("locations.maps." + Main.cfg.getString("config.mapname") + ".spawn" + i + ".world");
				
				Location loc = new Location(Bukkit.getWorld(world), x, y, z);
				loc.setYaw(yaw);
				loc.setPitch(pitch);
				
				all.teleport(loc);
			}
			i++;
		}
	}
	

}
