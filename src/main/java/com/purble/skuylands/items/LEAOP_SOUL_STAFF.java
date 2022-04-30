package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.Item;

public class LEAOP_SOUL_STAFF extends Item {

	public LEAOP_SOUL_STAFF(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}

}
