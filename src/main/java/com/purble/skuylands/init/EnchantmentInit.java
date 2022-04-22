package com.purble.skuylands.init;

import java.util.ArrayList;
import java.util.List;

import com.purble.skuylands.enchantments.LEA_UNDAMAGE;
import com.purble.skuylands.util.Referance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Referance.MOD_ID)
public class EnchantmentInit {

	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final Enchantment LEA_UNDAMAGE = new LEA_UNDAMAGE(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, 
			EntityEquipmentSlot.CHEST, 
			EntityEquipmentSlot.LEGS, 
			EntityEquipmentSlot.FEET});
	
}
