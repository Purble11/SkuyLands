package com.purble.skuylands.blocks.lea_wood.pressure_plate;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class LEA_PRESSURE_PLATE extends BlockPressurePlate {

	public LEA_PRESSURE_PLATE(String name) {
		super(Material.WOOD, Sensitivity.EVERYTHING);
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
