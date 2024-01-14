package de.dylogix.skywars.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.dylogix.skywars.enums.GameState;
import de.dylogix.skywars.main.Main;
import de.dylogix.skywars.methods.GameStateHandler;

public class DeathListener implements Listener {

	public DeathListener(de.dylogix.skywars.main.Main Main) {
		DeathListener.pl = Main;
	}

	private static de.dylogix.skywars.main.Main pl;
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl, () -> e.getEntity().spigot().respawn());
		
		e.setDeathMessage(null);

		if(Main.gs == GameState.INGAME) {
			if(Main.alive.contains(p)) {
				if(p.getKiller() == null) {
					Bukkit.broadcastMessage(Main.prefix + "§a" + p.getName() + " §7died.");
				} else {
					Bukkit.broadcastMessage(Main.prefix + "§a" + p.getName() + " §7was killed by §a" + p.getKiller().getName());
				}
				GameStateHandler.handleDeath(p);
			}
		}
	}
	
}
