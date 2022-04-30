package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemPickaxe;

public class LEAOP_SIDOOL extends ItemPickaxe {
	
	public LEAOP_SIDOOL(String mctag, ToolMaterial material) {
		
		super(material);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		this.attackDamage = 30.7F;
		this.attackSpeed = 1.7F;
		
		ItemInit.ITEMS.add(this);
	}

}
