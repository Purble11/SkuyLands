package com.purble.skuylands.util.handlers;

import java.io.File;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.util.Referance;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	public static Configuration config;
	
	//Entities
	public static int ENTITY_LEAOP_ARROW = 6912320;
	public static int ENTITY_LEAOP_LORD_MINION = 69456291;
	public static int ENTITY_LEAOP_LORD_MINION_PROJECTILE = 69789947;
	public static int ENTITY_LEAOPED_ORB_PROJECTILE = 697493629;
	
	//Gui's
	public static int GUI_LEAED_TABLE = 69101875;
	public static int GUI_LEA_CHEST = 69132415;
	
	//Dimensions
	public static int SKUYLANDS_HOME = 69849356;
	
	//Commands
	public static boolean TOGGLE_KILLME = true;
	
	public static void init(File file) {
		config = new Configuration(file);
		
		String category;
		
		category = "entity-ids";
		config.addCustomCategoryComment(category, "Note: Changing these ids might break somethings or corrupt a world with this mod");

		ENTITY_LEAOP_ARROW = config.getInt("LeaopArrow", category, 6912320, 0, 999999999, "ID for any Leaop Arrows shot");
		ENTITY_LEAOP_LORD_MINION = config.getInt("LeaopLordMinion", category, 69456291, 0, 999999999, "ID for any Leaop Lord Minion");
		ENTITY_LEAOP_LORD_MINION_PROJECTILE = config.getInt("LeaopLordMinionProjectile", category, 69789947, 0, 999999999, "ID for any Leaop Lord Minion Attack Projectile");
		ENTITY_LEAOPED_ORB_PROJECTILE = config.getInt("LeaopedOrbProjectile", category, 697493629, 0, 999999999, "ID for any Thrown Leaoped Orb");
		
		category = "gui-ids";
		config.addCustomCategoryComment(category, "Change Skuylands's Gui Ids");

		GUI_LEAED_TABLE = config.getInt("LeaedTableGui", category, 69101875, 0, 999999999, "ID for any Leaed Table Gui");
		GUI_LEA_CHEST = config.getInt("LeaChestGui", category, 69132415, 0, 999999999, "ID for any Lea Chest Gui");
		
		category = "dimension-ids";
		config.addCustomCategoryComment(category, "Change Skuyland's Dimension Ids");
		
		SKUYLANDS_HOME = config.getInt("SkuyLandsHome", category, 69849356, 0, 999999999, "ID for the Skuylands's Home Dimension");
		
		category = "commands";
		config.addCustomCategoryComment(category, "Enable or disable SkuyLands's Commands");

		TOGGLE_KILLME = config.getBoolean("killme", category, true, "Toggle the /killme command");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event) {
		SkuyLands.config = new File(event.getModConfigurationDirectory() + "/" + Referance.MOD_ID);
		SkuyLands.config.mkdirs();
		init(new File(SkuyLands.config.getPath(), Referance.MOD_ID + ".cfg"));
	}
}
