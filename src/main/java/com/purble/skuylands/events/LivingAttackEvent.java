package com.purble.skuylands.events;

import com.purble.skuylands.init.EnchantmentInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingAttackEvent {
	
	@SubscribeEvent
	public void onHitWithEnchantment(net.minecraftforge.event.entity.living.LivingAttackEvent event) {
		if(event.getEntity() instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.getEntity();
			if(entity.getHeldItemMainhand().getItem() == ItemInit.LEAOP_SIDOOL) {
				NBTTagCompound nbt = entity.getHeldItemMainhand().getTagCompound();
				
				try {
					nbt.setInteger("Uses", nbt.getInteger("Uses") + 1);
				} catch (NullPointerException e) {}
				
				entity.getHeldItemMainhand().setTagCompound(nbt);
			}
		}
		
		int value = 32;// Added this so i can edit it to lower or buff it
		//System.out.println("Skuylands-Debug: is the enchantment working???????????");
		if(event.getEntityLiving() instanceof EntityPlayer) {
			event.getEntityLiving().getArmorInventoryList().forEach(item -> {
				int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.LEA_UNDAMAGE, item);
				if(item.isItemEnchanted() && level > 0) {
					//if(event.getSource() == DamageSource.GENERIC) return;
					// Code above removes fall damage
					if(event.getSource() == DamageSource.OUT_OF_WORLD) return;
					int blockedAmount = level * value;
					if(blockedAmount >= event.getAmount()) {
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
