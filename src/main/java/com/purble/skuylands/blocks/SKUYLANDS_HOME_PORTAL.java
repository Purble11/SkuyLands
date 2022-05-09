package com.purble.skuylands.blocks;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.util.handlers.DimTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SKUYLANDS_HOME_PORTAL extends Block {

	public SKUYLANDS_HOME_PORTAL(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(SkuyLands.skuylands);
        this.setLightOpacity(1);
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if(worldIn.getBlockState(fromPos) == Blocks.AIR.getDefaultState()) {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn instanceof EntityPlayer && !worldIn.isRemote) {
			EntityPlayer playerIn = (EntityPlayer)entityIn;
			if(playerIn.dimension == 0)
				SkuyLands.changeDimToSkuyLandsHome((EntityPlayer)entityIn);
			else {
				double x = 0;
				double y = 0;
				double z = 0;
				
				try {
					x = (double)playerIn.getBedLocation().getX();
					y = (double)playerIn.getBedLocation().getY();
					z = (double)playerIn.getBedLocation().getZ();
					DimTeleporter.teleportToDimension(playerIn, 0, x, y, z);
				} catch (NullPointerException e) {
					x = (double)playerIn.world.getSpawnPoint().getX();
					z = (double)playerIn.world.getSpawnPoint().getZ();
					World worldIn2 = worldIn;
					worldIn2.provider.setDimension(0);
					DimTeleporter.teleportToDimension(playerIn, 0, x, calculatePosHeight(worldIn2, (int)x, (int)z), z);
				}
			}
		}
	}
	
	private static int calculatePosHeight(World world, int x, int z) {
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block != Blocks.AIR;
		}
		
		return y <= 10 ? 220 : y;
	}
	
}
