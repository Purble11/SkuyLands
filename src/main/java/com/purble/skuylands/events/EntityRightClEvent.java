package com.purble.skuylands.events;

import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.init.PotionInit;
import com.purble.skuylands.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityRightClEvent {

	@SubscribeEvent
	public void onEntityRightClick(EntityInteract event) {
		if(!event.getWorld().isRemote) {
			if(event.getItemStack() != ItemStack.EMPTY && 
				event.getItemStack().getItem() == ItemInit.LEAOP_SOUL_STAFF) {
				NBTTagCompound nbt;
				if(event.getItemStack().hasTagCompound()) nbt = event.getItemStack().getTagCompound();
				else nbt = new NBTTagCompound();
				
				if(!nbt.hasKey("effect_uses")) {
					nbt.setInteger("effect_uses", 999);
				} else {
					if(nbt.getInteger("effect_uses") <= 0) {
						event.getEntityPlayer().sendMessage(new TextComponentString("§cStaff is out of uses, Repair by Right-Clicking on a Block Of Leaop")); 
						return;
					}
					
					nbt.setInteger("effect_uses", nbt.getInteger("effect_uses") - 1);
				}
				
				event.getEntityPlayer().sendMessage(new TextComponentString("§6Uses Left: "+nbt.getInteger("effect_uses")+" (Right-Click Leaop Block To Repair)"));
				
				event.getItemStack().setTagCompound(nbt);
				if(!((EntityLivingBase)event.getTarget() instanceof EntityLeaopLordMinion)) {
					((EntityLivingBase)event.getTarget()).addPotionEffect(new PotionEffect(PotionInit.LEAOPED_POTION_EFFECT, 500, 1, false, true));
					event.getEntityPlayer().playSound(SoundsHandler.LEAOP_LORD_MINION_AMBIENT, 1.0F, 1.0F);
				} else {
					event.getEntityPlayer().inventory.removeStackFromSlot(EntityEquipmentSlot.MAINHAND.getSlotIndex());
					event.getEntityPlayer().getServer().getPlayerList().sendMessage(new TextComponentString("§cStaff Experianced To Much Energy"));
					event.getEntityPlayer().playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
				}
			}
		}
	}
}
