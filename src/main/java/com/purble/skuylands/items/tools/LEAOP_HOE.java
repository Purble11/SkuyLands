package com.purble.skuylands.items.tools;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemHoe;

public class LEAOP_HOE extends ItemHoe {
	
	public LEAOP_HOE(String mctag, ToolMaterial material) {
		
		super(material);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
}
