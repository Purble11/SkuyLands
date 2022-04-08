package com.purble.skuylands.init;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerArrow("leaop_arrow", EntityLeaopArrow.class, ConfigHandler.ENTITY_LEAOP_ARROW);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Referance.MOD_ID + ":" + name), entity, name, id, SkuyLands.instance, 64, 20, true);
	}

}
