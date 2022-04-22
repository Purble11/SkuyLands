package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LEAOPED_APPLE extends ItemFood {

	public LEAOPED_APPLE(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(SkuyLands.skuylands);
		setAlwaysEdible();
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 1200, 30));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 1200, 35));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(6), 1200, 20));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 60, 15));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 1200, 25));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 1200, 5));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 600, 35));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 1200, 20));
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(22), 600, 40));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public IRarity getForgeRarity(ItemStack stack) {
		return new IRarity() {
			@Override
			public String getName() {
				return "Semi-Impossible";
			}
			
			@Override
			public TextFormatting getColor() {
				return TextFormatting.AQUA;
			}
		};
	}

}
