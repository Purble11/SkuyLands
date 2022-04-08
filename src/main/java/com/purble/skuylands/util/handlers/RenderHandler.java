package com.purble.skuylands.util.handlers;

import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.entity.RenderLeaopArrow;

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
	}

}
