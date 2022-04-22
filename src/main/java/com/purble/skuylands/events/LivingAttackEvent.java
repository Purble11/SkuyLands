package com.purble.skuylands.events;

import com.purble.skuylands.init.EnchantmentInit;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingAttackEvent {
	
	@SubscribeEvent
	public void onHitWithEnchantment(net.minecraftforge.event.entity.living.LivingAttackEvent event) {
		if(event.getSource() == DamageSource.GENERIC) return;
		else if(event.getSource() == DamageSource.OUT_OF_WORLD) return;
		int value = 32;// Added this so i can edit it to lower or buff it
		//System.out.println("Skuylands-Debug: is the enchantment working???????????");
		if(event.getEntityLiving() instanceof EntityPlayer) {
			event.getEntityLiving().getArmorInventoryList().forEach(item -> {
				int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.LEA_UNDAMAGE, item);
				if(item.isItemEnchanted() && level > 0) {
					int blockedAmount = level * value;
					if(blockedAmount > event.getAmount()) {
						event.setCanceled(true);
					}
					/*event.setCanceled(true);
					event.getEntityLiving().setHealth(event.getEntityLiving().getHealth() + event.getAmount());
					int removedDamage = level * value;
					float damageTaken = event.getAmount() - removedDamage;
					damageTaken = damageTaken < 0 ? 0.0F : damageTaken;
					event.getEntityLiving().setHealth(event.getEntityLiving().getHealth() - damageTaken);*/
					return;
				}
			});
		}
	}

}
