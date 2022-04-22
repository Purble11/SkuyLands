package com.purble.skuylands.util.handlers;

import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.entity.RenderLeaopArrow;
import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.entity.leaoplordminion.RenderLeaopLordMinion;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaopArrow.class, new IRenderFactory<EntityLeaopArrow>() {
			@Override
			public Render<? super EntityLeaopArrow> createRenderFor(RenderManager manager) {
				return new RenderLeaopArrow(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaopLordMinion.class, new IRenderFactory<EntityLeaopLordMinion>() {
			@Override
			public Render<? super EntityLeaopLordMinion> createRenderFor(RenderManager manager) {
				return new RenderLeaopLordMinion(manager);
			}
		});
	}

}
