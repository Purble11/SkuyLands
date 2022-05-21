package com.purble.skuylands.items.tools;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemSword;

public class LEAOP_SWORD extends ItemSword {
	
	public LEAOP_SWORD(String mctag, ToolMaterial material) {
		
		super(material);
		
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		/*this.attackSpeed = 1.2F;
		this.attackDamage = 29.5F;*/
		
		ItemInit.ITEMS.add(this);
	}
	
}
