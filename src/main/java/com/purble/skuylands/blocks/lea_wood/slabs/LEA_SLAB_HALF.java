package com.purble.skuylands.blocks.lea_wood.slabs;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSlab;

public class LEA_SLAB_HALF extends LEA_SLAB {
	
	public LEA_SLAB_HALF(String name, Material materialIn, CreativeTabs tabIn, BlockSlab slabIn, BlockSlab doubleSlabIn) {
		super(name, materialIn, slabIn);
		setCreativeTab(tabIn);
		
		ItemInit.ITEMS.add(new ItemSlab(this, this, doubleSlabIn).setRegistryName(name));
	}
	
	@Override
	public boolean isDouble() {
		return false;
	}
	
}
