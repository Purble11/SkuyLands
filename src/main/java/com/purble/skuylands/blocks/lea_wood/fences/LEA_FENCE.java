package com.purble.skuylands.blocks.lea_wood.fences;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class LEA_FENCE extends BlockFence {

	public LEA_FENCE(String name) {
		super(Material.WOOD, MapColor.DIAMOND);
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
	
}
