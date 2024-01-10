package de.dylogix.skywars.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.dylogix.skywars.guis.KitSelectionInventory;

public class ItemClickListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem() != null) {
				if(e.getItem().getItemMeta().getDisplayName().equals("§akit select")) {
					KitSelectionInventory.open(p);
				}
			}
		}
	}
	
}
