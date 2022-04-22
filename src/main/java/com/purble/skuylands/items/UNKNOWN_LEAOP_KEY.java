package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.Item;

public class UNKNOWN_LEAOP_KEY extends Item {

	public UNKNOWN_LEAOP_KEY(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
}
