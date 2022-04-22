package com.purble.skuylands.entity.leaoplordminion;

import com.purble.skuylands.util.Referance;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaopLordMinion extends RenderLiving<EntityLeaopLordMinion> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Referance.MOD_ID + ":textures/entity/leaoplordminion/leoplordminion.png");
	static float shadowsizeIn = 1.0F;
	
	public RenderLeaopLordMinion(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new LeopLordMinion(), shadowsizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLeaopLordMinion entity) {
		return TEXTURE;
	}

}
