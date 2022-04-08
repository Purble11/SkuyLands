package com.purble.skuylands.items.tools;

import java.util.Set;

import com.google.common.collect.Sets;
import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class LEAOP_SWORD extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.WEB);
	
	public LEAOP_SWORD(String mctag, ToolMaterial material) {
		
		super(material, EFFECTIVE_ON);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		this.attackSpeed = 1.2F;
		this.attackDamage = 29.5F;
		
		ItemInit.ITEMS.add(this);
	}
	
}
