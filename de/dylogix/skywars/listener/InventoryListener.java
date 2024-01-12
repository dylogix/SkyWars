package de.dylogix.skywars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.main.Main;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getWhoClicked()))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getPlayer()))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onClick(EntityPickupItemEvent e) {
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getEntity()))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onClick(PlayerSwapHandItemsEvent e) {
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getPlayer()))
			e.setCancelled(true);
	}
}
