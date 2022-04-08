package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LEAOP_ARROW extends ItemArrow {
	
	public LEAOP_ARROW(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		setMaxDamage(6000);
		setMaxStackSize(64);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		
		if(shooter.getHeldItemMainhand().getItem() != ItemInit.LEAOP_BOW && shooter.getHeldItemOffhand().getItem() != ItemInit.LEAOP_BOW) {
			EntityTippedArrow entitytippedarrow = new EntityTippedArrow(worldIn, shooter);
	        entitytippedarrow.setPotionEffect(stack);
	        return entitytippedarrow;
		}
		
		EntityLeaopArrow entityLeaopArrow = new EntityLeaopArrow(worldIn, shooter);
		
		return entityLeaopArrow;
	}

}
