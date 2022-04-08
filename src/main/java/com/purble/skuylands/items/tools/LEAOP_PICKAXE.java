package com.purble.skuylands.items.tools;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemPickaxe;

public class LEAOP_PICKAXE extends ItemPickaxe {
	
	public LEAOP_PICKAXE(String mctag, ToolMaterial material) {
		
		super(material);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
}
