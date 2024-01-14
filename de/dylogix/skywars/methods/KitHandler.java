package de.dylogix.skywars.methods;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import de.dylogix.skywars.enums.Kit;

public class KitHandler {

	private static HashMap<Player, Kit> kitassignment = new HashMap<Player, Kit>();
	
	public static void assignKit(Player p, Kit kit) {
		if(kitassignment.containsKey(p)) {
			kitassignment.replace(p, kit);
		} else {
			kitassignment.put(p, kit);
		}
	}
	
	public static Kit getKit(Player p) {
		return kitassignment.get(p);
	}
	
	public static void giveKit(Player p) {
		Kit kit = kitassignment.get(p);
		
		setKit(p, kit);
	}
	
	public static ItemStack getKitSelectItem(Kit kit) {
		switch(kit) {
		case BRICKLAYER:
			ItemStack bricklayer = create(Material.BRICKS, 1);
			ItemMeta bricklayer_meta = bricklayer.getItemMeta();
			bricklayer_meta.setDisplayName("§aBricklayer");
			ArrayList<String> bricklayer_lore = new ArrayList<String>();
			bricklayer_lore.add("§7- 3x64 Bricks");
			bricklayer_lore.add("§7- 1x Gold Helmet (Protection 1, Unbreaking 10)");
			bricklayer_meta.setLore(bricklayer_lore);
			bricklayer.setItemMeta(bricklayer_meta);
			
			return bricklayer;
		case WIZARD:
			ItemStack wizard = create(Material.EXPERIENCE_BOTTLE, 1);
			ItemMeta wizard_meta = wizard.getItemMeta();
			wizard_meta.setDisplayName("§aWizard");
			ArrayList<String> wizard_lore = new ArrayList<String>();
			wizard_lore.add("§7- 32x Experience Bottle");
			wizard_lore.add("§7- 1x Enchantment Table");
			wizard_meta.setLore(wizard_lore);
			wizard.setItemMeta(wizard_meta);
			
			return wizard;
		case CRAFTER:
			ItemStack crafter = create(Material.CRAFTING_TABLE, 1);
			ItemMeta crafter_meta = crafter.getItemMeta();
			crafter_meta.setDisplayName("§aCrafter");
			ArrayList<String> crafter_lore = new ArrayList<String>();
			crafter_lore.add("§7- 64x Crafting Table");
			crafter_lore.add("§7- 64x Stick");
			crafter_lore.add("§7- 32x Anvil");
			crafter_lore.add("§7- 5x Iron Ingot");
			crafter_lore.add("§7- 5x Diamond");
			crafter_lore.add("§7- 5x Coal");
			crafter_meta.setLore(crafter_lore);
			crafter.setItemMeta(crafter_meta);
			
			return crafter;
		case TANK:
			ItemStack tank = create(Material.IRON_CHESTPLATE, 1);
			ItemMeta tank_meta = tank.getItemMeta();
			tank_meta.setDisplayName("§aTank");
			ArrayList<String> tank_lore = new ArrayList<String>();
			tank_lore.add("§7- 1x Iron Helmet (Protection 10)");
			tank_lore.add("§7- 1x Iron Chestplate (Protection 10)");
			tank_lore.add("§7- 1x Iron Leggings (Protection 10)");
			tank_lore.add("§7- 1x Iron Boots (Protection 10)");
			tank_lore.add("§7- 1x Splash Potion of Fire Resistance");
			tank_meta.setLore(tank_lore);
			tank.setItemMeta(tank_meta);
			
			return tank;
		case ASSASIN:
			ItemStack assasin = create(Material.DIAMOND_SWORD, 1);
			ItemMeta assasin_meta = assasin.getItemMeta();
			assasin_meta.setDisplayName("§aAssasin");
			ArrayList<String> assasin_lore = new ArrayList<String>();
			assasin_lore.add("§7- 1x Diamond Sword (Sharpness 1, Unbreaking 10)");
			assasin_lore.add("§7- 1x Diamond Boots (Feather Falling 3, Unbreaking 10)");
			assasin_meta.setLore(assasin_lore);
			assasin.setItemMeta(assasin_meta);
			
			return assasin;
		case PIRATE:
			ItemStack pirate = create(Material.FIREWORK_STAR, 1);
			ItemMeta pirate_meta = pirate.getItemMeta();
			pirate_meta.setDisplayName("§aPirate");
			ArrayList<String> pirate_lore = new ArrayList<String>();
			pirate_lore.add("§7- 32x Fire Charge");
			pirate_lore.add("§7- 3x Dispenser");
			pirate_lore.add("§7- 3x Lever");
			pirate_lore.add("§7- 1x Leather Helmet (Protection 2, Blast Protection 2)");
			pirate_lore.add("§7- 1x Golden Sword (Sharpness 2)");
			pirate_meta.setLore(pirate_lore);
			pirate.setItemMeta(pirate_meta);
			
			return pirate;
		case MINER:
			ItemStack miner = create(Material.DIAMOND_PICKAXE, 1);
			ItemMeta miner_meta = miner.getItemMeta();
			miner_meta.setDisplayName("§aMiner");
			ArrayList<String> miner_lore = new ArrayList<String>();
			miner_lore.add("§7- 1x Diamond Pickaxe (Efficiency 10, Unbreaking 10)");
			miner_lore.add("§7- 1x Diamond Helmet (Protection 2, Unbreaking 10)");
			miner_meta.setLore(miner_lore);
			miner.setItemMeta(miner_meta);
			
			return miner;
		case FARMER:
			ItemStack farmer = create(Material.WHEAT, 1);
			ItemMeta farmer_meta = farmer.getItemMeta();
			farmer_meta.setDisplayName("§aFarmer");
			ArrayList<String> farmer_lore = new ArrayList<String>();
			farmer_lore.add("§7- 64x Hay Bale");
			farmer_lore.add("§7- 32x Torch");
			farmer_lore.add("§7- 16x Bread");
			farmer_lore.add("§7- 1x Iron Hoe (Sharpness 2, Unbreaking 10)");
			farmer_meta.setLore(farmer_lore);
			farmer.setItemMeta(farmer_meta);
			
			return farmer;
		case SNOWMAN:
			ItemStack snowman = create(Material.SNOWBALL, 1);
			ItemMeta snowman_meta = snowman.getItemMeta();
			snowman_meta.setDisplayName("§aSnowman");
			ArrayList<String> snowman_lore = new ArrayList<String>();
			snowman_lore.add("§7- 5x Coal");
			snowman_lore.add("§7- 3x Snow Block");
			snowman_lore.add("§7- 1x Carrot");
			snowman_lore.add("§7- 1x Iron Shovel (Unbreaking 10)");
			snowman_meta.setLore(snowman_lore);
			snowman.setItemMeta(snowman_meta);
			
			return snowman;
		case ENDERMAN:
			ItemStack enderman = create(Material.ENDER_PEARL, 1);
			ItemMeta enderman_meta = enderman.getItemMeta();
			enderman_meta.setDisplayName("§aEnderman");
			ArrayList<String> enderman_lore = new ArrayList<String>();
			enderman_lore.add("§7- 1x Enderpearl");
			enderman_lore.add("§7- 1x Leather Chestplate");
			enderman_meta.setLore(enderman_lore);
			enderman.setItemMeta(enderman_meta);
			
			return enderman;
		case WITCH:
			ItemStack witch = create(Material.SPLASH_POTION, 1);
			ItemMeta witch_meta = witch.getItemMeta();
			witch_meta.setDisplayName("§aWitch");
			ArrayList<String> witch_lore = new ArrayList<String>();
			witch_lore.add("§7- 3x Splash Potion of Regeneration");
			witch_lore.add("§7- 1x Splash Potion of Poison");
			witch_meta.setLore(witch_lore);
			witch.setItemMeta(witch_meta);
			
			return witch;
		case ARCHER:
			ItemStack archer = create(Material.BOW, 1);
			ItemMeta archer_meta = archer.getItemMeta();
			archer_meta.setDisplayName("§aArcher");
			ArrayList<String> archer_lore = new ArrayList<String>();
			archer_lore.add("§7- 3x Arrow");
			archer_lore.add("§7- 1x Bow");
			archer_meta.setLore(archer_lore);
			archer.setItemMeta(archer_meta);
			
			return archer;
		default:
			ItemStack starter = create(Material.IRON_PICKAXE, 1);
			ItemMeta starter_meta = starter.getItemMeta();
			starter_meta.setDisplayName("§aStarter");
			ArrayList<String> starter_lore = new ArrayList<String>();
			starter_lore.add("§7- 1x Iron Pickaxe");
			starter_lore.add("§7- 1x Iron Sword");
			starter_lore.add("§7- 1x Iron Axe");
			starter_meta.setLore(starter_lore);
			starter.setItemMeta(starter_meta);
			
			return starter;
		}
	}
	
	private static ItemStack create(Material mat, int amount) {
        return new ItemStack(mat, amount);
    }
	
	private static ItemStack createPotion(Material mat, PotionType pt, int amount, Boolean arg, Boolean arg2) {
		ItemStack potion = new ItemStack(mat, amount);
    	PotionMeta meta = (PotionMeta) potion.getItemMeta();
    	meta.setBasePotionData(new PotionData(pt, arg, arg2));
    	potion.setItemMeta(meta);
    	
    	return potion;
	}
	
	private static ItemStack createEnchanted(Material mat, Enchantment ench, int level) {
    	ItemStack item = new ItemStack(mat);
    	ItemMeta meta = item.getItemMeta();
    	meta.addEnchant(ench, level, true);
    	item.setItemMeta(meta);
		
    	return item;
	}
		
	private static void setKit(Player p, Kit kit) {
		switch(kit) {
		case BRICKLAYER:
			ItemStack bricklayer_helmet = create(Material.GOLDEN_HELMET, 1);
			ItemMeta meta = bricklayer_helmet.getItemMeta();
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
			meta.addEnchant(Enchantment.DURABILITY, 10, true);
			bricklayer_helmet.setItemMeta(meta);

			p.getInventory().addItem(create(Material.BRICKS, 64));
			p.getInventory().addItem(create(Material.BRICKS, 64));
			p.getInventory().addItem(create(Material.BRICKS, 64));
			p.getInventory().addItem(bricklayer_helmet);
			
			return;
		case WIZARD:
			p.getInventory().addItem(create(Material.EXPERIENCE_BOTTLE, 32));
			p.getInventory().addItem(create(Material.ENCHANTING_TABLE, 1));
			
			return;
		case CRAFTER:
			p.getInventory().addItem(create(Material.CRAFTING_TABLE, 64));
			p.getInventory().addItem(create(Material.ANVIL, 32));
			p.getInventory().addItem(create(Material.STICK, 64));
			p.getInventory().addItem(create(Material.IRON_INGOT, 5));
			p.getInventory().addItem(create(Material.DIAMOND, 5));
			p.getInventory().addItem(create(Material.COAL, 5));
			
			return;
		case TANK:
			ItemStack tank_helmet = create(Material.IRON_HELMET, 1);
			ItemMeta tank_helmet_meta = tank_helmet.getItemMeta();
			tank_helmet_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			tank_helmet.setItemMeta(tank_helmet_meta);
			
			ItemStack tank_chest = create(Material.IRON_CHESTPLATE, 1);
			ItemMeta tank_chest_meta = tank_chest.getItemMeta();
			tank_chest_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			tank_chest.setItemMeta(tank_chest_meta);
			
			ItemStack tank_leggings = create(Material.IRON_LEGGINGS, 1);
			ItemMeta tank_leggings_meta = tank_leggings.getItemMeta();
			tank_leggings_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			tank_leggings.setItemMeta(tank_leggings_meta);

			ItemStack tank_boots = create(Material.IRON_BOOTS, 1);
			ItemMeta tank_boots_meta = tank_boots.getItemMeta();
			tank_boots_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			tank_boots.setItemMeta(tank_boots_meta);
			
			p.getInventory().addItem(createPotion(Material.POTION, PotionType.FIRE_RESISTANCE, 1, true, false));
			p.getInventory().addItem(tank_helmet);
			p.getInventory().addItem(tank_chest);
			p.getInventory().addItem(tank_leggings);
			p.getInventory().addItem(tank_boots);
			
			return;
		case ASSASIN:
			ItemStack assasin_sword = create(Material.DIAMOND_SWORD, 1);
			ItemMeta assasin_sword_meta = assasin_sword.getItemMeta();
			assasin_sword_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			assasin_sword_meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			assasin_sword.setItemMeta(assasin_sword_meta);
			
			ItemStack assasin_boots = create(Material.DIAMOND_BOOTS, 1);
			ItemMeta assasin_boots_meta = assasin_boots.getItemMeta();
			assasin_boots_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			assasin_boots_meta.addEnchant(Enchantment.PROTECTION_FALL, 3, true);
			assasin_boots.setItemMeta(assasin_boots_meta);

			p.getInventory().addItem(assasin_sword);
			p.getInventory().addItem(assasin_boots);
			
			return;
		case PIRATE:
			ItemStack pirate_helmet = create(Material.LEATHER_HELMET, 1);
			ItemMeta pirate_helmet_meta = pirate_helmet.getItemMeta();
			pirate_helmet_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
			pirate_helmet_meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
			pirate_helmet.setItemMeta(pirate_helmet_meta);
			
			p.getInventory().addItem(pirate_helmet);
			p.getInventory().addItem(createEnchanted(Material.GOLDEN_SWORD, Enchantment.DAMAGE_ALL, 2));
			p.getInventory().addItem(create(Material.DISPENSER, 3));
			p.getInventory().addItem(create(Material.FIRE_CHARGE, 32));
			p.getInventory().addItem(create(Material.LEVER, 3));
			
			return;
		case MINER:
			ItemStack miner_pickaxe = create(Material.DIAMOND_PICKAXE, 1);
			ItemMeta miner_pickaxe_meta = miner_pickaxe.getItemMeta();
			miner_pickaxe_meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
			miner_pickaxe_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			miner_pickaxe.setItemMeta(miner_pickaxe_meta);
			
			ItemStack miner_helmet = create(Material.IRON_HELMET, 1);
			ItemMeta miner_helmet_meta = miner_helmet.getItemMeta();
			miner_helmet_meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
			miner_helmet_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			miner_helmet.setItemMeta(miner_helmet_meta);

			p.getInventory().addItem(miner_pickaxe);
			p.getInventory().addItem(miner_helmet);
			
			return;
		case FARMER:
			ItemStack farmer_hoe = create(Material.IRON_HOE, 1);
			ItemMeta farmer_hoe_meta = farmer_hoe.getItemMeta();
			farmer_hoe_meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
			farmer_hoe_meta.addEnchant(Enchantment.DURABILITY, 10, true);
			farmer_hoe.setItemMeta(farmer_hoe_meta);
			
			p.getInventory().addItem(farmer_hoe);
			p.getInventory().addItem(create(Material.HAY_BLOCK, 64));
			p.getInventory().addItem(create(Material.TORCH, 32));
			p.getInventory().addItem(create(Material.BREAD, 16));
			
			return;
		case SNOWMAN:
			p.getInventory().addItem(createEnchanted(Material.IRON_SHOVEL, Enchantment.DURABILITY, 10));
			p.getInventory().addItem(create(Material.SNOW_BLOCK, 3));
			p.getInventory().addItem(create(Material.CARROT, 1));
			p.getInventory().addItem(create(Material.COAL, 5));
			
			return;
		case ENDERMAN:
			ItemStack enderman_chest = create(Material.LEATHER_CHESTPLATE, 1);
			LeatherArmorMeta enderman_chest_meta = (LeatherArmorMeta) enderman_chest.getItemMeta();
			enderman_chest_meta.setColor(Color.BLACK);
			enderman_chest_meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
			enderman_chest.setItemMeta(enderman_chest_meta);
			
			p.getInventory().addItem(createEnchanted(Material.ENDER_PEARL, Enchantment.ARROW_INFINITE, 1));
			p.getInventory().addItem(enderman_chest);
			
			return;
		case WITCH:
			p.getInventory().addItem(createPotion(Material.SPLASH_POTION, PotionType.POISON, 1, false, false));
			p.getInventory().addItem(createPotion(Material.SPLASH_POTION, PotionType.REGEN, 3, false, false));
			
			return;
		case ARCHER:
			p.getInventory().addItem(create(Material.BOW, 1));
			p.getInventory().addItem(create(Material.ARROW, 3));
			
			return;
		default:
			p.getInventory().addItem(create(Material.IRON_PICKAXE, 1)); 
			p.getInventory().addItem(create(Material.IRON_SWORD, 1));
			p.getInventory().addItem(create(Material.IRON_AXE, 1));
			return;
		}
	}
	
	

}
