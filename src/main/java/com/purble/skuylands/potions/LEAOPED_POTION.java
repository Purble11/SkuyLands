package com.purble.skuylands.potions;

import com.purble.skuylands.util.Referance;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class LEAOPED_POTION extends Potion {

	public LEAOPED_POTION(String name, boolean isBadEffectIn, int liquidColorIn, int iconIndexX, int iconIndexY) {
		super(isBadEffectIn, liquidColorIn);
		setPotionName("effect."+name);
		setIconIndex(iconIndexX, iconIndexY);
		setRegistryName(new ResourceLocation(Referance.MOD_ID+":"+name));
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Referance.MOD_ID+":textures/gui/potions_effects.png"));
		return true;
	}

}
