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

import de.dylogix.skywars.enums.Kit;
import de.dylogix.skywars.methods.KitHandler;

public class KitSelectionInventory implements Listener {
	
	public static void open(Player p) {
		p.playSound(p, Sound.BLOCK_CHEST_OPEN, 10.0F, 10.0F);
		
		Inventory inv = Bukkit.createInventory(null, 9*4, "§3Kit Select");
		
		ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta panemeta = pane.getItemMeta();
		panemeta.setDisplayName(" ");
		pane.setItemMeta(panemeta);
		
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

		inv.setItem(10, KitHandler.getKitSelectItem(Kit.STARTER));
		inv.setItem(11, KitHandler.getKitSelectItem(Kit.BRICKLAYER));
		inv.setItem(12, KitHandler.getKitSelectItem(Kit.WIZARD));
		inv.setItem(13, KitHandler.getKitSelectItem(Kit.CRAFTER));
		inv.setItem(14, KitHandler.getKitSelectItem(Kit.TANK));
		inv.setItem(15, KitHandler.getKitSelectItem(Kit.ASSASIN));
		inv.setItem(16, KitHandler.getKitSelectItem(Kit.PIRATE));
		
		inv.setItem(17, pane);
		inv.setItem(18, pane);
		
		inv.setItem(19, KitHandler.getKitSelectItem(Kit.SNOWMAN));
		inv.setItem(20, KitHandler.getKitSelectItem(Kit.FARMER));
		inv.setItem(21, KitHandler.getKitSelectItem(Kit.MINER));
		inv.setItem(22, KitHandler.getKitSelectItem(Kit.ENDERMAN));
		inv.setItem(23, KitHandler.getKitSelectItem(Kit.WITCH));
		inv.setItem(24, KitHandler.getKitSelectItem(Kit.ARCHER));
		
		inv.setItem(26, pane);
		inv.setItem(27, pane);
		inv.setItem(28, pane);
		inv.setItem(29, pane);
		inv.setItem(30, pane);
		inv.setItem(31, pane);
		inv.setItem(32, pane);
		inv.setItem(33, pane);
		inv.setItem(34, pane);
		inv.setItem(35, pane);
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().equals("§3Kit Select")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem() != null) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aStarter")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.STARTER);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aBricklayer")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.BRICKLAYER);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aWizard")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.WIZARD);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aCrafter")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.CRAFTER);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTank")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.TANK);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAssasin")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.ASSASIN);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aPirate")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.PIRATE);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSnowman")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.SNOWMAN);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aFarmer")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.FARMER);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aMiner")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.MINER);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aEnderman")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.ENDERMAN);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aWitch")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.WITCH);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aArcher")) {
					e.getView().close();
					p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
					KitHandler.assignKit(p, Kit.ARCHER);
				}
			}
		}
	}
}
