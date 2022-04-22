package com.purble.skuylands.events;

import java.util.Random;

import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableEvent {
	
	@SubscribeEvent
	public void customLootTableDrop(LivingDropsEvent event) {
		Random rand = new Random();
		
		int firstItemChance = 7;
		int secondItemChance = 3;
		
		if(event.getEntityLiving() instanceof EntityLeaopLordMinion) {
			if(rand.nextInt(firstItemChance) == 0) {
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.LEAOPED_APPLE), 0.0F);
				
				return;
			} else if(rand.nextInt(secondItemChance) == 0) {
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.LEAOP_BLOCK), 0.0F);
				
				return;
			}
		}
	}
	
}
