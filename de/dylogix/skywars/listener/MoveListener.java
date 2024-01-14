package de.dylogix.skywars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.dylogix.skywars.main.Main;

public class MoveListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(Main.movelock.contains(e.getPlayer())) {
			if(e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ())
			    e.setTo(e.getFrom());
		}
	}
	
}
