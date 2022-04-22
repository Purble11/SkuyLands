package com.purble.skuylands.util.handlers;

import com.purble.skuylands.events.*;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void registerEvents() {
		LootTableEvent lootTableEvent = new LootTableEvent();
		LivingAttackEvent livingAttackEvent = new LivingAttackEvent();
		
		MinecraftForge.EVENT_BUS.register(lootTableEvent);
		MinecraftForge.EVENT_BUS.register(livingAttackEvent);
	}
	
}
