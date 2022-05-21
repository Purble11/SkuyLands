package com.purble.skuylands.items.tools;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemAxe;

public class LEAOP_AXE extends ItemAxe {
	
	public LEAOP_AXE(String mctag, ToolMaterial material) {
		
		super(material, 34.5F, 1.0F);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
}
