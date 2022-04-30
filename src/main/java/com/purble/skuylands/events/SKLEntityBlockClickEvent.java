package com.purble.skuylands.events;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SKLEntityBlockClickEvent {

	@SubscribeEvent
	public void onBlockRightClick(RightClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		if(block == BlockInit.LEAOP_BLOCK && 
				event.getItemStack().getItem() == ItemInit.LEAOP_SOUL_STAFF) {
			event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
			event.getWorld().setBlockToAir(event.getPos());
			NBTTagCompound nbt = event.getItemStack().getTagCompound();
			nbt.removeTag("effect_uses");
			event.getItemStack().setTagCompound(nbt);
		}
	}
	
	@SubscribeEvent
	public void onBlockLeftClick(LeftClickBlock event) {
		Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
		if(block == BlockInit.LEAOP_BLOCK && 
				event.getItemStack().getItem() == ItemInit.LEAOP_SOUL_STAFF) {
			event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
			event.getWorld().setBlockToAir(event.getPos());
			NBTTagCompound nbt = event.getItemStack().getTagCompound();
			nbt.removeTag("effect_uses");
			event.getItemStack().setTagCompound(nbt);
		}
	}
	
}
