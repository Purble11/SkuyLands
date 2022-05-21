package com.purble.skuylands.blocks.leaed_table;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.util.handlers.ConfigHandler;

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

public class LEAED_TABLE extends Block {

	public LEAED_TABLE(String name, Material materialIn) {
		super(materialIn);
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
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
			float hitX, float hitY, float hitZ) {
		super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).openGui(SkuyLands.instance, ConfigHandler.GUI_LEAED_TABLE, world, x, y, z);
		}
		return true;
	}
	
}
