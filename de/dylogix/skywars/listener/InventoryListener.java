package de.dylogix.skywars.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dylogix.skywars.enums.GameState;
import de.dylogix.skywars.main.Main;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getWhoClicked()))
			e.setCancelled(true);
		
		if(e.getCurrentItem() != null) {
			if(e.getInventory().getType() == InventoryType.ENCHANTING && e.getCurrentItem().getItemMeta().getDisplayName().equals("§1Smurf Powder")) {
				e.setCancelled(true);
			}
		}
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
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent e) {
		if(e.getInventory().getType() == InventoryType.ENCHANTING) {
			ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 64);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§1Smurf Powder");
			item.setItemMeta(meta);
			
			e.getInventory().setItem(1, item);
		}
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		if(e.getView().getType() == InventoryType.ENCHANTING) {
			e.getInventory().setItem(1, null);
		}
	}
}
