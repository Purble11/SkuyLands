package com.purble.skuylands.blocks.lea_wood.doors;

import java.util.Random;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.blocks.lea_wood.itemblocks.ItemBlockDoor;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class LEA_DOOR extends BlockDoor {

	public LEA_DOOR(String name) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		this.setHardness(7);
		this.setHarvestLevel("axe", 3);
		this.setSoundType(SoundType.WOOD);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(this);
	}
	
}
