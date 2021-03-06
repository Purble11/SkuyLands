package com.purble.skuylands.proxy;

import com.purble.skuylands.entity.EntityCustomKillProjectile;
import com.purble.skuylands.entity.EntityLeaopedOrbProjectile;
import com.purble.skuylands.entity.leaoplordminionarrow.EntityLeaopLordMinionProjectile;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void render() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaopLordMinionProjectile.class, new RenderSnowball<EntityLeaopLordMinionProjectile>(Minecraft.getMinecraft().getRenderManager(), ItemInit.LEAOP_INGOT, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaopedOrbProjectile.class, new RenderSnowball<EntityLeaopedOrbProjectile>(Minecraft.getMinecraft().getRenderManager(), ItemInit.LEAOPED_ORB, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomKillProjectile.class, new RenderSnowball<EntityCustomKillProjectile>(Minecraft.getMinecraft().getRenderManager(), ItemInit.POWERED_LEAOP_SHARD, Minecraft.getMinecraft().getRenderItem()));
	}
}
