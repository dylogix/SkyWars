package de.dylogix.skywars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.main.Main;

public class DamageListener implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(Main.gs != GameState.INGAME)
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onHungerChange(FoodLevelChangeEvent e) {
		if(Main.gs != GameState.INGAME)
			e.setCancelled(true);
	}

}
