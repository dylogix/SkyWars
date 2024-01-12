package de.dylogix.skywars.methods;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.main.Main;

public class GameStateHandler implements Listener{
	
	public GameStateHandler(de.dylogix.skywars.main.Main Main) {
		GameStateHandler.pl = Main;
	}

	private static de.dylogix.skywars.main.Main pl;
	
	public static int lobby_countdown;
	static int lobby_counter;

	public static int game_countdown;
	static int game_counter;

	public static int end_countdown;
	static int end_counter;
	
	public static void startLobbyCountdown() {
		if(!Bukkit.getScheduler().isCurrentlyRunning(lobby_countdown)){
			lobby_counter = 11;
			lobby_countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {

				@Override
				public void run() {
					if(Bukkit.getOnlinePlayers().size() > 1){
						lobby_counter--;
						
						float onepercent = (float) (100.0 / 60.0);
						float current_percentage = lobby_counter * onepercent;
						
						for(Player all : Bukkit.getOnlinePlayers()){
							all.setLevel(lobby_counter);
							all.setExp((float) current_percentage /100);
						}
							
						if(lobby_counter == 60 || lobby_counter == 10 || lobby_counter == 5 || lobby_counter == 4 || lobby_counter == 3 || lobby_counter == 2 ) {
							for(Player all : Bukkit.getOnlinePlayers()){
								all.playSound(all, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 10.0F);
							}
						} else if(lobby_counter == 1) {
							for(Player all : Bukkit.getOnlinePlayers()){	
								all.playSound(all, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 10.0F);
							}
						}
							
						if(lobby_counter == 0) {
							Bukkit.getScheduler().cancelTask(lobby_countdown);
							
							Main.gs = GameState.STARTING;
								
							LocationHandler.teleportAllPlayersToMap();
								
							startGameCountdown();

							for(Player all : Bukkit.getOnlinePlayers()){
								all.getInventory().clear();
								all.playSound(all, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
								Main.alive.add(all);
							}
						}
					} else {
						Bukkit.getScheduler().cancelTask(lobby_countdown);
						lobby_counter = 61;
						
						for(Player all : Bukkit.getOnlinePlayers()){
							all.setLevel(0);
							all.setExp(0);
						}
					}
				}
			}, 20, 20);
		}
	}
		
	public static void startGameCountdown() {
		if(!Bukkit.getScheduler().isCurrentlyRunning(game_countdown)){
			
			for(Player all : Bukkit.getOnlinePlayers()) {
			Main.movelock.add(all);
			}
			
			game_counter = 6;
			game_countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					game_counter--;
					
					for(Player all : Bukkit.getOnlinePlayers()){		
						if(game_counter == 0) {
							Bukkit.getScheduler().cancelTask(game_countdown);
							
							Main.movelock.remove(all);
							
							Main.gs = GameState.INGAME;
							
							all.sendTitle("§7» §f§lSkyWars §7«", "§7Eliminate all other players.");
							all.playSound(all, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);
						} else if(game_counter == 1){
							all.sendTitle("§7» §f§lSkyWars §7«", "§7Game starts in §a" + game_counter + " §7second.");
							all.playSound(all, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 10.0F);
						} else {
							all.sendTitle("§7» §f§lSkyWars §7«", "§7Game starts in §a" + game_counter + " §7seconds.");
							all.playSound(all, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 10.0F);
						}
					}
				}
			}, 20, 20);
		}
	}
	
	public static void startEndCountdown() {
		if(!Bukkit.getScheduler().isCurrentlyRunning(end_countdown)){
						
			end_counter = 11;
			end_countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					end_counter--;
						
						if(end_counter == 0) {
							Bukkit.getScheduler().cancelTask(end_countdown);
							for(Player all : Bukkit.getOnlinePlayers()){	
								all.kickPlayer("§cLobby closed.");
							}
							Bukkit.getServer().shutdown();
						} else {
							for(Player all : Bukkit.getOnlinePlayers()){
								all.sendTitle("", "§cLobby cloeses in " + end_counter);
							}
						}
				}
			}, 20, 20);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void handleDeath(Player p) {
		Main.alive.remove(p);
		
		if(Main.alive.size() == 1) {
			Main.gs = GameState.ENDING;
			Bukkit.broadcastMessage(Main.prefix + "Game over! §a" + Main.alive.get(0).getName() + "§7 won §aSkyWars§7!");
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.setGameMode(GameMode.SURVIVAL);
				all.getInventory().clear();
				all.setExp(0);
				all.setLevel(0);
				all.setHealth(20);
				all.setFoodLevel(20);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, () -> LocationHandler.teleportPlayerToLobby(all));
				
				all.sendTitle("§7» §f§lSkyWars §7«", "§a" + Main.alive.get(0).getName() + " §7won §aSkyWars§7!");
				all.playSound(all, Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 10.0F);

			}
			startEndCountdown();
		} else {
			p.setGameMode(GameMode.SPECTATOR);
			Bukkit.getScheduler().scheduleSyncDelayedTask(pl, () -> LocationHandler.teleportPlayerToSpecSpawn(p));
			
		}
	}
}
