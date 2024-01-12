package de.dylogix.skywars.methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.main.Main;

public class ScoreboardHandler implements Listener{
	
	private static de.dylogix.skywars.main.Main pl;
	
	public ScoreboardHandler(de.dylogix.skywars.main.Main Main2)
	{ 
	  pl = Main2;
	}
    
	@SuppressWarnings("deprecation")
	public static void setScoreboard(Player p) {
		if(Main.gs == GameState.LOBBY) {
	    	Scoreboard board2 = Bukkit.getScoreboardManager().getNewScoreboard();
	        Objective ob = board2.registerNewObjective("lobby", "system");
	        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
	        ob.setDisplayName(" §8»  §f§lSkyWars §8« ");
	        Score sm0 = ob.getScore(ChatColor.GREEN.toString());
	        Score sm1 = ob.getScore("  §7Map");
	        Score sm2 = ob.getScore("    §8➥ §a" + Main.cfg.get("config.mapname"));
	        Score s = ob.getScore(ChatColor.RED.toString());
	        Score s0 = ob.getScore("  §7Min. Players");
	        Score s1 = ob.getScore("    §8➥ §a" + Main.cfg.get("config.min_players"));
	        Score s2 = ob.getScore(ChatColor.YELLOW.toString());
	        
	        s2.setScore(1);
	        s1.setScore(2);
	        s0.setScore(3);
	        s.setScore(4);
	        sm2.setScore(5);
	        sm1.setScore(6);
	        sm0.setScore(7);
	        p.setScoreboard(board2);
		} else {
	    	Scoreboard board2 = Bukkit.getScoreboardManager().getNewScoreboard();
	        Objective ob = board2.registerNewObjective("lobby", "system");
	        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
	        ob.setDisplayName(" §8»  §f§lSkyWars §8« ");
	        Score sm0 = ob.getScore(ChatColor.GREEN.toString());
	        Score sm1 = ob.getScore("  §7Map");
	        Score sm2 = ob.getScore("    §8➥ §a" + Main.cfg.get("config.mapname"));
	        Score s = ob.getScore(ChatColor.RED.toString());
	        Score s0 = ob.getScore("  §7Players alive");
	        Score s1 = ob.getScore("    §8➥ §a" + Main.alive.size());
	        Score s2 = ob.getScore(ChatColor.YELLOW.toString());
	        
	        s2.setScore(1);
	        s1.setScore(2);
	        s0.setScore(3);
	        s.setScore(4);
	        sm2.setScore(5);
	        sm1.setScore(6);
	        sm0.setScore(7);
	        p.setScoreboard(board2);
		}
		
    }
	public static void startUpdatingBoard() {
		for(Player all : Bukkit.getOnlinePlayers()) {
			ScoreboardHandler.setScoreboard(all);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl,  new Runnable() {
			@Override
			public void run() {
				startUpdatingBoard2();
			}
		}, 25L);
	}
	public static void startUpdatingBoard2() {
		for(Player all : Bukkit.getOnlinePlayers()) {
			ScoreboardHandler.setScoreboard(all);
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl,  new Runnable() {
			@Override
			public void run() {
				startUpdatingBoard();
			}
		}, 25L);
	}
}