package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.EntityLeaopArrow;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LEAOP_ARROW extends Item {
	
	public LEAOP_ARROW(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		setMaxDamage(6000);
		setMaxStackSize(64);
		
		ItemInit.ITEMS.add(this);
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player){
		int enchant = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == LEAOP_ARROW.class;
	}
	
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		EntityLeaopArrow entityLeaopArrow = new EntityLeaopArrow(worldIn, shooter);
		return entityLeaopArrow;
	}

}
