package de.dylogix.skywars.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.main.Main;

public class JoinQuitListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		if(Main.gs == GameState.LOBBY) {
			Bukkit.broadcastMessage(Main.prefix + p.getName() + " joined the lobby.");
			
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			p.getInventory().setItemInOffHand(null);
			p.setLevel(2024);
			p.setExp(0);
			p.setFoodLevel(20);
			
			ItemStack kitselect = new ItemStack(Material.CHEST);
			ItemMeta kitmeta = kitselect.getItemMeta();
			kitmeta.setDisplayName("§akit select");
			kitselect.setItemMeta(kitmeta);
			
			p.getInventory().setItem(4, kitselect);
			
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
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		
		if(Main.gs == GameState.LOBBY)
			Bukkit.broadcastMessage(Main.prefix + e.getPlayer().getName() + " left the lobby.");
	}
}
