package com.purble.skuylands.recipes;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes {
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlockInit.LEAOP_ORE), new ItemStack(ItemInit.LEAOP_INGOT), 10.0F);
	}
}
