package com.purble.skuylands.items.tools;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemSpade;

public class LEAOP_SHOVEL extends ItemSpade {
	
	public LEAOP_SHOVEL(String mctag, ToolMaterial material) {
		
		super(material);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
}
