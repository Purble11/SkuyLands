package com.purble.skuylands.blocks;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LEA_PLANKS extends Block {

	public LEA_PLANKS(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		this.setHardness(7);
		this.setHarvestLevel("axe", 3);
		this.setSoundType(SoundType.WOOD);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(playerIn.getHeldItem(hand).getItem() == ItemInit.UNKNOWN_LEAOP_KEY) {
			if(isPortal(worldIn, pos)) {
				playerIn.getHeldItem(hand).shrink(1);
				playerIn.swingArm(hand);
				worldIn.setBlockState(pos.up(), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
				worldIn.setBlockState(pos.up(2), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
				worldIn.setBlockState(pos.up(3), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
				//fill the portal
				worldIn.setBlockState(pos.north().up(4), BlockInit.LEA_BARK.getDefaultState());
				worldIn.setBlockState(pos.up(4), BlockInit.LEA_BARK.getDefaultState());
				worldIn.setBlockState(pos.south().up(4), BlockInit.LEA_BARK.getDefaultState());
				worldIn.setBlockState(pos.south().up(3), BlockInit.LEA_BARK.getDefaultState());
			}
		}
		
		return false;
	}
	
	private boolean isPortal(World worldIn, BlockPos pos) {
		if(worldIn.getBlockState(pos.up()) != BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState()) {
			if(worldIn.getBlockState(pos.north()) == BlockInit.LEA_PLANKS.getDefaultState() 
					&& worldIn.getBlockState(pos.south()) == BlockInit.LEA_PLANKS.getDefaultState() 
					&& worldIn.getBlockState(pos.north().up()) == BlockInit.LEA_PLANKS.getDefaultState() 
					&& worldIn.getBlockState(pos.south().up()) == BlockInit.LEA_PLANKS.getDefaultState() 
					&& worldIn.getBlockState(pos.south().up(2)) == BlockInit.LEA_PLANKS.getDefaultState() 
					&& worldIn.getBlockState(pos.north().up(2)) == BlockInit.LEA_BARK.getDefaultState() 
					&& worldIn.getBlockState(pos.north().up(3)) == BlockInit.LEA_BARK.getDefaultState()) {
				return true;//continue portal check
			}
		} else {
			return false;
		}
		
		return false;
	}

}
