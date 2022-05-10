package com.purble.skuylands.blocks;

import java.util.Random;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.world.gen.WorldGenCustomStructures;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LEA_SAPLING extends Block {

	public LEA_SAPLING(String name) {
		super(Material.PLANTS);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		setTickRandomly(true);
		this.setHardness(6.6F);
		this.setHarvestLevel("axe", 3);
		this.setSoundType(SoundType.PLANT);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		if(worldIn.isRemote) return;
		
		if(worldIn.getBlockState(pos.down()).getBlock() == BlockInit.LEAED_VOID) {
			if(RANDOM.nextInt(50) <= 12) {
				WorldGenCustomStructures.TREE.generate(worldIn, RANDOM, pos.add(-2, 0, -2));
			}
		} else {
			worldIn.destroyBlock(pos, true);
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if(worldIn.getBlockState(pos.down()).getBlock() != BlockInit.LEAED_VOID)
			worldIn.destroyBlock(pos, true);
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock() == BlockInit.LEAED_VOID ? true : false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.isRemote) return false;
		
		if(playerIn.getHeldItem(hand).getItem() == Items.DYE && ((ItemDye)playerIn.getHeldItem(hand).getItem()).getMetadata(playerIn.getHeldItem(hand)) == 15) {
			playerIn.getHeldItem(hand).shrink(1);
			playerIn.playSound(SoundEvents.ITEM_HOE_TILL, 1.0f, 1.0f);
			
			if(RANDOM.nextInt(100) <= 12) {
				WorldGenCustomStructures.TREE.generate(worldIn, RANDOM, pos.add(-2, 0, -2));
			}
			
			return true;
		}
		
		return false;
	}
	
}
