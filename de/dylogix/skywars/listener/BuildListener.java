package de.dylogix.skywars.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.dylogix.skywars.enums.GameState;
import de.dylogix.skywars.main.Main;

public class BuildListener implements Listener {
	
	@EventHandler
	public void BlockBreakEvent(BlockBreakEvent e) {
		if((Main.gs != GameState.INGAME) && !Main.buildoverride.contains(e.getPlayer()))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void BlockPlaceEvent(BlockPlaceEvent e) {
		if((Main.gs != GameState.INGAME) && !Main.buildoverride.contains(e.getPlayer()))
			e.setCancelled(true);
		
		if((e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.TRAPPED_CHEST) && !Main.buildoverride.contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.prefix + "§cYou're not allowed to place chests.");
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getClickedBlock() != null) {
			if((e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST) && !Main.buildoverride.contains(e.getPlayer())) {
				e.setCancelled(true);
			}
		}
		
		if(Main.gs != GameState.INGAME && !Main.buildoverride.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}
}
