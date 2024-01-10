package de.dylogix.skywars.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelectionInventory implements Listener {
	
	public static void open(Player p) {
		p.playSound(p, Sound.BLOCK_CHEST_OPEN, 10.0F, 10.0F);
		
		Inventory inv = Bukkit.createInventory(null, 9*3, "§3Kit Select");
		
		ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta panemeta = pane.getItemMeta();
		panemeta.setDisplayName(" ");
		pane.setItemMeta(panemeta);
		
		ItemStack comingsoon = new ItemStack(Material.BARRIER);
		ItemMeta comingsoonmeta = comingsoon.getItemMeta();
		comingsoonmeta.setDisplayName("§cThis feature is work in progress.");
		comingsoon.setItemMeta(comingsoonmeta);
		
		inv.setItem(0, pane);
		inv.setItem(1, pane);
		inv.setItem(2, pane);
		inv.setItem(3, pane);
		inv.setItem(4, pane);
		inv.setItem(5, pane);
		inv.setItem(6, pane);
		inv.setItem(7, pane);
		inv.setItem(8, pane);
		
		inv.setItem(9, pane);
		inv.setItem(10, pane);
		inv.setItem(11, pane);
		inv.setItem(12, pane);

		inv.setItem(14, pane);
		inv.setItem(15, pane);
		inv.setItem(16, pane);
		inv.setItem(17, pane);
		
		inv.setItem(18, pane);
		inv.setItem(19, pane);
		inv.setItem(20, pane);
		inv.setItem(21, pane);
		inv.setItem(22, pane);
		inv.setItem(23, pane);
		inv.setItem(24, pane);
		inv.setItem(25, pane);
		inv.setItem(26, pane);
		
		inv.setItem(13, comingsoon);
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent e) {
		if(e.getView().getTitle().equals("§3Kit Select")) {
			e.setCancelled(true);
		}
	}
}
