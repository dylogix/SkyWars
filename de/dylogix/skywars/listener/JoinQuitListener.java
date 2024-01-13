package de.dylogix.skywars.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
import de.dylogix.skywars.methods.GameStateHandler;
import de.dylogix.skywars.methods.LocationHandler;

public class JoinQuitListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		if(Main.gs == GameState.LOBBY) {
			if(Bukkit.getOnlinePlayers().size() > Main.cfg.getInt("config.max_players")) {
				p.kickPlayer("§cThis lobby is already full.");
			} else {
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.getInventory().setItemInOffHand(null);
				p.setLevel(0);
				p.setExp(0);
				p.setFoodLevel(20);
				
				ItemStack kitselect = new ItemStack(Material.CHEST);
				ItemMeta kitmeta = kitselect.getItemMeta();
				kitmeta.setDisplayName("§akit select");
				kitselect.setItemMeta(kitmeta);
				
				p.getInventory().setItem(4, kitselect);
				
				ChestListener.openchests.put(e.getPlayer(), 0);
				
				LocationHandler.teleportPlayerToLobby(p);
				
				if(Bukkit.getOnlinePlayers().size() >= Main.cfg.getInt("config.min_players")) {
					GameStateHandler.startLobbyCountdown();
				}
			}
		} else if(Main.gs == GameState.ENDING) {
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			p.getInventory().setItemInOffHand(null);
			p.setLevel(0);
			p.setExp(0);
			p.setFoodLevel(20);

			LocationHandler.teleportPlayerToLobby(p);
		} else if(Main.gs == GameState.RESETTING) {		
			p.kickPlayer("§cThe game has ended. Please wait for the server to restart.");
		} else {
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			p.getInventory().setItemInOffHand(null);
			p.setLevel(0);
			p.setExp(0);
			p.setFoodLevel(20);
			
			p.setGameMode(GameMode.SPECTATOR);
			LocationHandler.teleportPlayerToSpecSpawn(p);
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		
		Main.alive.remove(e.getPlayer());
		
		if(Main.gs == GameState.INGAME) {
			GameStateHandler.handleDeath(e.getPlayer());
		}
	}
}
