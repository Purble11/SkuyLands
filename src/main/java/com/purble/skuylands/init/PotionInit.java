package com.purble.skuylands.init;

import com.purble.skuylands.potions.*;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionInit {

	public static final Potion LEAOPED_POTION_EFFECT = new LEAOPED_POTION("LEAOPED_POTION".toLowerCase(), false, 6151167, 0, 0);
	public static final Potion POWERED_THROWN_AWAY_EFFECT = new POWERED_THROWN_AWAY("POWERED_THROWN_AWAY".toLowerCase(), false, 16777215, 1, 0);

	public static final PotionType LEAOPED_POTION = new PotionType("LEAOPED_POTION".toLowerCase(), new PotionEffect[] {new PotionEffect(LEAOPED_POTION_EFFECT, 500, 1)}).setRegistryName("LEAOPED_POTION".toLowerCase());
	public static final PotionType POWERED_THROWN_AWAY_POTION = new PotionType("POWERED_THROWN_AWAY".toLowerCase(), new PotionEffect[] {new PotionEffect(LEAOPED_POTION_EFFECT, 1, 1)}).setRegistryName("POWERED_THROWN_AWAY".toLowerCase());
	public static final PotionType LONG_LEAOPED_POTION = new PotionType("LEAOPED_POTION".toLowerCase(), new PotionEffect[] {new PotionEffect(LEAOPED_POTION_EFFECT, 1000, 1)}).setRegistryName("LONG_LEAOPED_POTION".toLowerCase());
	
	public static void registerPotions() {
		registerPotion(LEAOPED_POTION, LONG_LEAOPED_POTION, LEAOPED_POTION_EFFECT);
		registerPotion(POWERED_THROWN_AWAY_POTION, POWERED_THROWN_AWAY_EFFECT);
		
		registerPotionMixes();
	}
	
	public static void registerPotion(PotionType defaultPotion, PotionType longPotion, Potion effect) {
		ForgeRegistries.POTIONS.register(effect);
		ForgeRegistries.POTION_TYPES.register(defaultPotion);
		ForgeRegistries.POTION_TYPES.register(longPotion);
	}
	
	public static void registerPotion(PotionType defaultPotion, Potion effect) {
		ForgeRegistries.POTIONS.register(effect);
		ForgeRegistries.POTION_TYPES.register(defaultPotion);
	}
	
	private static void registerPotionMixes() {
		PotionHelper.addMix(LEAOPED_POTION, Items.REDSTONE, LONG_LEAOPED_POTION);
		PotionHelper.addMix(PotionTypes.AWKWARD, ItemInit.LEAOPED_APPLE, LEAOPED_POTION);
		PotionHelper.addMix(PotionTypes.AWKWARD, ItemInit.POWERED_LEA_SWORD, POWERED_THROWN_AWAY_POTION);
	}
	
}
