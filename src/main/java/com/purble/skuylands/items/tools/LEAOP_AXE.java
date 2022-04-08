package com.purble.skuylands.items.tools;

import java.util.Set;

import com.google.common.collect.Sets;
import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class LEAOP_AXE extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, 
			Blocks.BOOKSHELF, 
			Blocks.LOG, 
			Blocks.LOG2, 
			Blocks.CHEST, 
			Blocks.PUMPKIN, 
			Blocks.LIT_PUMPKIN, 
			Blocks.MELON_BLOCK, 
			Blocks.LADDER, 
			Blocks.WOODEN_BUTTON, 
			Blocks.WOODEN_PRESSURE_PLATE, 
			BlockInit.LEA_LOG, 
			BlockInit.LEA_PLANKS);
	
	public LEAOP_AXE(String mctag, ToolMaterial material) {
		
		super(material, EFFECTIVE_ON);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		this.attackSpeed = 1;
		this.attackDamage = 34.5F;
		
		ItemInit.ITEMS.add(this);
	}
	
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
	}
	
}
