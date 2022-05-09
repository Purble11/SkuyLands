package com.purble.skuylands.blocks;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.init.SoundTypeInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class LEAED_VOID extends Block {

	public LEAED_VOID(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
        this.setLightOpacity(1);
		this.setHardness(69.5F);
		this.setSoundType(SoundTypeInit.SOLID_VOID);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
}
