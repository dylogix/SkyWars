package de.dylogix.skywars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.dylogix.skywars.gamestate.GameState;
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
	}
}
