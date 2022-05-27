package com.purble.skuylands.util.handlers;

import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.entity.RenderLeaopArrow;
import com.purble.skuylands.entity.leaboat.EntityLeaBoat;
import com.purble.skuylands.entity.leaboat.RenderLeaBoat;
import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.entity.leaoplordminion.RenderLeaopLordMinion;
import com.purble.skuylands.entity.leapet.EntityLeaPet;
import com.purble.skuylands.entity.leapet.RenderLeaPet;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaPet.class, new IRenderFactory<EntityLeaPet>() {
			@Override
			public Render<? super EntityLeaPet> createRenderFor(RenderManager manager) {
				return new RenderLeaPet(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaBoat.class, new IRenderFactory<EntityLeaBoat>() {
			@Override
			public Render<? super EntityLeaBoat> createRenderFor(RenderManager manager) {
				return new RenderLeaBoat(manager);
			}
		});
	}

}
