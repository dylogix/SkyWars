package de.dylogix.skywars.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import de.dylogix.skywars.main.Main;
import de.dylogix.skywars.methods.GameStateHandler;
import de.dylogix.skywars.methods.LocationHandler;
import de.dylogix.skywars.methods.MapresetHandler;

public class TestCommand implements CommandExecutor {
	
	// command simply for testing

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("test")) {
			p.sendMessage(Main.prefix + "Command received");
			
			if(args[0].equalsIgnoreCase("lobby")) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					LocationHandler.teleportPlayerToLobby(all);
				}
			} else if(args[0].equalsIgnoreCase("start")) {
				p.sendMessage(Main.prefix + "Lobby countdown started!");
				GameStateHandler.startLobbyCountdown();
			} else if(args[0].equalsIgnoreCase("reset")) {
				p.sendMessage(Main.prefix + "Mapreset started!");
				MapresetHandler.runMapreset();
			} else if(args[0].equalsIgnoreCase("potion")) {
		    	ItemStack regeneration = new ItemStack(Material.POTION);
		    	PotionMeta regpotionmeta = (PotionMeta) regeneration.getItemMeta();
		    	regpotionmeta.setBasePotionData(new PotionData(PotionType.REGEN, false, true));
		    	regeneration.setItemMeta(regpotionmeta);
		    	
		    	p.getInventory().addItem(regeneration);
			}
		}
		return true;
	}
}
