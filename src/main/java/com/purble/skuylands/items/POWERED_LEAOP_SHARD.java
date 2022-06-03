package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.Item;

public class POWERED_LEAOP_SHARD extends Item {

	public POWERED_LEAOP_SHARD(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}

}
