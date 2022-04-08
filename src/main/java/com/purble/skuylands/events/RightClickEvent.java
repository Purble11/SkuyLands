package com.purble.skuylands.events;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class RightClickEvent {
	
	@SubscribeEvent
	public void onRightClick(KeyInputEvent event) {
		if(Minecraft.getMinecraft().player.getHeldItemMainhand() == new ItemStack(ItemInit.LEAOP_BOW) && !Minecraft.getMinecraft().player.inventory.hasItemStack(new ItemStack(ItemInit.LEAOP_ARROW))) {
			event.setCanceled(true);
		} else if(Minecraft.getMinecraft().player.getHeldItemMainhand() == new ItemStack(Items.BOW) && !Minecraft.getMinecraft().player.inventory.hasItemStack(new ItemStack(Items.ARROW))) {
			event.setCanceled(true);
		} else if(Minecraft.getMinecraft().player.getHeldItemOffhand() == new ItemStack(ItemInit.LEAOP_BOW) && !Minecraft.getMinecraft().player.inventory.hasItemStack(new ItemStack(ItemInit.LEAOP_ARROW))) {
			event.setCanceled(true);
		} else if(Minecraft.getMinecraft().player.getHeldItemOffhand() == new ItemStack(Items.BOW) && !Minecraft.getMinecraft().player.inventory.hasItemStack(new ItemStack(Items.ARROW))) {
			event.setCanceled(true);
		}
	}
	
}
