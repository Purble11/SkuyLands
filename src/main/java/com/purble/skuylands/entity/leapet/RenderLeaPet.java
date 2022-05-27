package com.purble.skuylands.entity.leapet;

import com.purble.skuylands.util.Referance;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaPet extends RenderLiving<EntityLeaPet> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Referance.MOD_ID + ":textures/entity/leapet/leapet.png");
	static float shadowsizeIn = 1.0F;
	
	public RenderLeaPet(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new LeaPet(), shadowsizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLeaPet entity) {
		return TEXTURE;
	}
	
}
