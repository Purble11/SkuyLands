package com.purble.skuylands.enchantments;

import com.purble.skuylands.init.EnchantmentInit;
import com.purble.skuylands.util.Referance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class LEA_UNDAMAGE extends Enchantment {

	public LEA_UNDAMAGE(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, typeIn, slots);
		this.setName("LEA_UNDAMAGE".toLowerCase());
		this.setRegistryName(new ResourceLocation(Referance.MOD_ID + ":LEA_UNDAMAGE".toLowerCase()));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return enchantmentLevel * 18;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) * 18;
	}
	
	@Override
	public int getMaxLevel() {
		return 4;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench == Enchantments.PROTECTION ? false : true;
	}

}
