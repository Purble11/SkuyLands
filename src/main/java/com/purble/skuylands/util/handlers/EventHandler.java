package com.purble.skuylands.util.handlers;

import com.purble.skuylands.events.*;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void registerEvents() {
		LootTableEvent lootTableEvent = new LootTableEvent();
		LivingAttackEvent livingAttackEvent = new LivingAttackEvent();
		EntityRightClEvent entityRightClEvent = new EntityRightClEvent();
		SKLEntityTickEvent sklEntityTickEvent = new SKLEntityTickEvent();
		SKLEntityBlockClickEvent sklEntityBlockClickEvent = new SKLEntityBlockClickEvent();
		// Structure events don't work
		//StructureEvents structureEvents = new StructureEvents();

		MinecraftForge.EVENT_BUS.register(lootTableEvent);
		MinecraftForge.EVENT_BUS.register(livingAttackEvent);
		MinecraftForge.EVENT_BUS.register(entityRightClEvent);
		MinecraftForge.EVENT_BUS.register(sklEntityTickEvent);
		MinecraftForge.EVENT_BUS.register(sklEntityBlockClickEvent);
		//MinecraftForge.EVENT_BUS.register(structureEvents);
	}
	
}
