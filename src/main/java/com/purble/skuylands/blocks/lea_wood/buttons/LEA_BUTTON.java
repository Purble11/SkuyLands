package com.purble.skuylands.blocks.lea_wood.buttons;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import net.minecraft.item.ItemBlock;

public class LEA_BUTTON extends BlockButtonWood {

	public LEA_BUTTON(String name) {
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
