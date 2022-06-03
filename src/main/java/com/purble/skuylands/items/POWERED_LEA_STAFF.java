package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.EntityCustomKillProjectile;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class POWERED_LEA_STAFF extends Item {

	public POWERED_LEA_STAFF(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		setMaxStackSize(1);
		setMaxDamage(150);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		ItemStack mat = new ItemStack(ItemInit.POWERED_LEAOP_SHARD);
		if (!mat.isEmpty() && OreDictionary.itemMatches(mat, repair, false)) return true;
		return super.getIsRepairable(toRepair, repair);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			if(this.getDamage(playerIn.getHeldItem(handIn)) != 150) {
				EntityCustomKillProjectile throwable = new EntityCustomKillProjectile(worldIn, playerIn);
				EntityCustomKillProjectile throwable1 = new EntityCustomKillProjectile(worldIn, playerIn);
				EntityCustomKillProjectile throwable2 = new EntityCustomKillProjectile(worldIn, playerIn);
				EntityCustomKillProjectile throwable3 = new EntityCustomKillProjectile(worldIn, playerIn);
				EntityCustomKillProjectile throwable4 = new EntityCustomKillProjectile(worldIn, playerIn);
				throwable.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(throwable);
				
				throwable1.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 6, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(throwable1);
				
				throwable2.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 12, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(throwable2);
	
				throwable3.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 6, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(throwable3);
	
				throwable4.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 12, 0.0F, 1.5F, 1.0F);
				worldIn.spawnEntity(throwable4);
				
				playerIn.getHeldItem(handIn).damageItem(1, playerIn);
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
			}
			
			playerIn.sendMessage(new TextComponentString("§cYou ran out of charges! (Repair with Powered Leaop Shard)"));
			
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
}
