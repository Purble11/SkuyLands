package com.purble.skuylands.init;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.EntityCustomKillProjectile;
import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.entity.EntityLeaopedOrbProjectile;
import com.purble.skuylands.entity.leaboat.EntityLeaBoat;
import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.entity.leaoplordminionarrow.EntityLeaopLordMinionProjectile;
import com.purble.skuylands.entity.leapet.EntityLeaPet;
import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerArrow("leaop_arrow", EntityLeaopArrow.class, ConfigHandler.ENTITY_LEAOP_ARROW);
		registerEntity("leaop_lord_minion", EntityLeaopLordMinion.class, ConfigHandler.ENTITY_LEAOP_LORD_MINION, 50, 30975, 65535);
		registerEntity("lea_pet", EntityLeaPet.class, ConfigHandler.ENTITY_LEA_PET, 50, 65535, 30975);
		registerProjectile("leaop_lord_minion_projectile", EntityLeaopLordMinionProjectile.class, ConfigHandler.ENTITY_LEAOP_LORD_MINION_PROJECTILE, ItemInit.LEAOP_INGOT);
		registerProjectile("leaoped_orb_projectile", EntityLeaopedOrbProjectile.class, ConfigHandler.ENTITY_LEAOPED_ORB_PROJECTILE, ItemInit.LEAOPED_ORB);
		registerProjectile("custom_kill_projectile", EntityCustomKillProjectile.class, ConfigHandler.ENTITY_CUSTOM_KILL_PROJECTILE, ItemInit.POWERED_LEAOP_SHARD);
		registerOtherEntity("lea_boat", EntityLeaBoat.class, ConfigHandler.ENTITY_LEA_BOAT, 50);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Referance.MOD_ID + ":" + name), entity, name, id, SkuyLands.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Referance.MOD_ID + ":" + name), entity, name, id, SkuyLands.instance, 64, 20, true);
	}
	
	private static void registerProjectile(String name, Class<? extends Entity> entity, int id, Item item) {
		EntityRegistry.registerModEntity(new ResourceLocation(Referance.MOD_ID + ":" + name), entity, name, id, SkuyLands.instance, 64, 10, true);
	}
	
	private static void registerOtherEntity(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Referance.MOD_ID + ":" + name), entity, name, id, SkuyLands.instance, 64, 10, true);
	}

}
