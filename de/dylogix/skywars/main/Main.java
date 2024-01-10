package de.dylogix.skywars.main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.dylogix.skywars.commands.BuildCommand;
import de.dylogix.skywars.commands.SetSpawnCommand;
import de.dylogix.skywars.gamestate.GameState;
import de.dylogix.skywars.guis.KitSelectionInventory;
import de.dylogix.skywars.listener.BuildListener;
import de.dylogix.skywars.listener.DamageListener;
import de.dylogix.skywars.listener.InventoryListener;
import de.dylogix.skywars.listener.ItemClickListener;
import de.dylogix.skywars.listener.JoinQuitListener;
import de.dylogix.skywars.methods.ScoreboardHandler;

public class Main extends JavaPlugin {
	
	// public variables
	
	public static String prefix = "§8| §aSkyWars §8» §7";
	public static GameState gs = GameState.LOBBY;
	public static ArrayList<Player> buildoverride = new ArrayList<Player>();
	
	public static File config;
	public static YamlConfiguration cfg;
	
	//
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Starting plugin...");
		
		config = new File("plugins//SkyWars//config.yml");
		cfg = YamlConfiguration.loadConfiguration(config);
		
		// register listener
		Bukkit.getPluginManager().registerEvents(new BuildListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new ItemClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new KitSelectionInventory(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
		Bukkit.getPluginManager().registerEvents(new ScoreboardHandler(this), this);
		
		// register commands
		getCommand("build").setExecutor(new BuildCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		
		ScoreboardHandler.startUpdatingBoard();

		Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Starting successful.");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§c[SkyWars] Shutting down plugin...");
	}
}
