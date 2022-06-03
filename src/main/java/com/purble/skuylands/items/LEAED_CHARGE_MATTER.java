package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.Item;

public class LEAED_CHARGE_MATTER extends Item {

	public LEAED_CHARGE_MATTER(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}

}
