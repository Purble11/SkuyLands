package com.purble.skuylands.blocks.lea_wood.slabs;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class LEA_SLAB_DOUBLE extends LEA_SLAB {

	public LEA_SLAB_DOUBLE(String name, Material materialIn, BlockSlab slabIn) {
		super(name, materialIn, slabIn);
		//setCreativeTab(tabIn);
	}
	
	@Override
	public boolean isDouble() {
		return true;
	}

}
