package com.purble.skuylands.util.handlers;

import com.purble.skuylands.util.Referance;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
	
	public static SoundEvent LEAOP_LORD_MINION_AMBIENT;
	public static SoundEvent LEAOP_LORD_MINION_DEATH;
	
	//SoundTypes
	public static SoundEvent SOLID_VOID_BREAK;
	public static SoundEvent SOLID_VOID_STEP;
	public static SoundEvent SOLID_VOID_PLACE;
	public static SoundEvent SOLID_VOID_HIT;
	public static SoundEvent SOLID_VOID_FALL;
	
	public static void registerSounds() {
		LEAOP_LORD_MINION_AMBIENT = registerSound("entity.leaop_lord_minion.LEAOP_LORD_MINION_AMBIENT".toLowerCase());
		LEAOP_LORD_MINION_DEATH = registerSound("entity.leaop_lord_minion.LEAOP_LORD_MINION_DEATH".toLowerCase());
		SOLID_VOID_BREAK = registerSound("blocks.solid_void.BREAK".toLowerCase());
		SOLID_VOID_STEP = registerSound("blocks.solid_void.STEP".toLowerCase());
		SOLID_VOID_PLACE = registerSound("blocks.solid_void.PLACE".toLowerCase());
		SOLID_VOID_HIT = registerSound("blocks.solid_void.HIT".toLowerCase());
		SOLID_VOID_FALL = registerSound("blocks.solid_void.FALL".toLowerCase());
	}
	
	private static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(Referance.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

}
