package com.purble.skuylands.init;

import com.purble.skuylands.util.handlers.SoundsHandler;

import net.minecraft.block.SoundType;

public class SoundTypeInit {

	public static final SoundType SOLID_VOID = new SoundType(1.0F, 1.0F, 
			SoundsHandler.SOLID_VOID_BREAK, 
			SoundsHandler.SOLID_VOID_STEP, 
			SoundsHandler.SOLID_VOID_PLACE, 
			SoundsHandler.SOLID_VOID_HIT, 
			SoundsHandler.SOLID_VOID_FALL);

}
