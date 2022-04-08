package com.purble.skuylands.tabs;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SkuyLandsTab extends CreativeTabs {

	public SkuyLandsTab(String label) {
		super("skuylandstab");
		this.setBackgroundImageName("skuylandstab.png");
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.LEAOP_INGOT);
	}

}
