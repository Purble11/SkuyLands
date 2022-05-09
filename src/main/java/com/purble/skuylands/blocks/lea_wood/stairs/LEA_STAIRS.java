package com.purble.skuylands.blocks.lea_wood.stairs;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class LEA_STAIRS extends BlockStairs {

	public LEA_STAIRS(String name, IBlockState modelState, CreativeTabs tab, float hardness, float resistance, SoundType sound, String harvestLevel, int level) {
		super(modelState);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(sound);
		setHarvestLevel(harvestLevel, level);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

}
