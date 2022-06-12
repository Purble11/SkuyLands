package com.purble.skuylands.potions;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.util.Referance;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class POWERED_THROWN_AWAY extends Potion {

	public POWERED_THROWN_AWAY(String name, boolean isBadEffectIn, int liquidColorIn, int iconIndexX, int iconIndexY) {
		super(isBadEffectIn, liquidColorIn);
		setPotionName("effect."+name);
		setIconIndex(iconIndexX, iconIndexY);
		setRegistryName(new ResourceLocation(Referance.MOD_ID+":"+name));
	}
	
	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn,
			AbstractAttributeMap attributeMapIn, int amplifier) {
		super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
		if(entityLivingBaseIn instanceof EntityPlayer)
			SkuyLands.killPlayer((EntityPlayer)entityLivingBaseIn, "Powered Throwen Away");
		else
			SkuyLands.killEntity(entityLivingBaseIn);
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Referance.MOD_ID+":textures/gui/potions_effects.png"));
		return true;
	}

}
