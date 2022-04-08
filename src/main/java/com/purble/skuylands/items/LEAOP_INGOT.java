package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.Item;

public class LEAOP_INGOT extends Item {

	public LEAOP_INGOT(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}

}
