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
	public static boolean TOGGLE_KILLME = true;
	
	public static void init(File file) {
		config = new Configuration(file);
		
		String category;
		
		category = "entity-ids";
		config.addCustomCategoryComment(category, "Note: Changing these ids might break somethings or corrupt a world with this mod");

		ENTITY_LEAOP_ARROW = config.getInt("LeaopArrow", category, 6912320, 0, 500, "ID for any Leaop Arrows shot");
		
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
