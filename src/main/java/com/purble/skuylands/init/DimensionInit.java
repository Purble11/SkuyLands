package com.purble.skuylands.init;

import com.purble.skuylands.world.skuylandsHome.DimensionSkuyLandsHome;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {

	public static final DimensionType SKUYLANDS_HOME = DimensionType.register("SkuyLandsHome", "_skuylandshome", ConfigHandler.SKUYLANDS_HOME, DimensionSkuyLandsHome.class, false);
	
	public static void registerDimensions() {
		DimensionManager.registerDimension(ConfigHandler.SKUYLANDS_HOME, SKUYLANDS_HOME);
	}
	
}
