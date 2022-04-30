package com.purble.skuylands.events;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.init.PotionInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SKLEntityTickEvent {
	@SubscribeEvent
	public void onEntityTick(LivingUpdateEvent event) {
		if(event.getEntityLiving().isPotionActive(PotionInit.LEAOPED_POTION_EFFECT)) {
			event.getEntityLiving().removePotionEffect(PotionInit.LEAOPED_POTION_EFFECT);
			if(event.getEntityLiving() instanceof EntityPlayer)
				SkuyLands.killPlayer((EntityPlayer)event.getEntityLiving(), "Leaoped Potion");
			else if(!(event.getEntityLiving() instanceof EntityLeaopLordMinion))
				SkuyLands.killEntity(event.getEntityLiving());
		}
	}
	
}
