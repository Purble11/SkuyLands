package com.purble.skuylands.proxy;

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
	
	@Override
	public void render() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLeaopLordMinionProjectile.class, new RenderSnowball<EntityLeaopLordMinionProjectile>(Minecraft.getMinecraft().getRenderManager(), ItemInit.LEAOP_INGOT, Minecraft.getMinecraft().getRenderItem()));
	}
}
