package com.purble.skuylands.entity;

import com.purble.skuylands.util.Referance;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaopArrow extends RenderArrow<EntityLeaopArrow> {

	public RenderLeaopArrow(RenderManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLeaopArrow entity) {
		return new ResourceLocation(Referance.MOD_ID + ":textures/entity/arrows/leaop_arrow.png");
	}

}
