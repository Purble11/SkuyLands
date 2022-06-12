package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LEAED_TABLE_RECIPE_BOOK extends Item {

	public LEAED_TABLE_RECIPE_BOOK(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		playerIn.openGui(SkuyLands.instance, ConfigHandler.GUI_LEAED_TABLE_RECIPE_BOOK, worldIn, x, y, z);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		return onItemRightClick(worldIn, player, hand).getType();
	}
	
}
