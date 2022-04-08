package com.purble.skuylands.util.handlers;

import com.purble.skuylands.events.RightClickEvent;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void registerEvents() {
		RightClickEvent rightClickEvent = new RightClickEvent();
		
		MinecraftForge.EVENT_BUS.register(rightClickEvent);
	}
	
}
