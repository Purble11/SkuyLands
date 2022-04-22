package com.purble.skuylands.util.handlers;

import com.purble.skuylands.util.Referance;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
	
	public static SoundEvent LEAOP_LORD_MINION_AMBIENT;
	public static SoundEvent LEAOP_LORD_MINION_DEATH;
	
	public static void registerSounds() {
		LEAOP_LORD_MINION_AMBIENT = registerSound("entity.leaop_lord_minion.LEAOP_LORD_MINION_AMBIENT".toLowerCase());
		LEAOP_LORD_MINION_DEATH = registerSound("entity.leaop_lord_minion.LEAOP_LORD_MINION_DEATH".toLowerCase());
	}
	
	private static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(Referance.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

}
