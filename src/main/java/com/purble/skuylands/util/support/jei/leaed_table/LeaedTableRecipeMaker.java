/*package com.purble.skuylands.util.support.jei.leaed_table;

import java.util.List;

import com.google.common.collect.Lists;
import com.purble.skuylands.init.BlockInit;

import mezz.jei.api.IJeiHelpers;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class LeaedTableRecipeMaker {

	public static List<LeaedTableRecipe> getRecipes(IJeiHelpers helpers) {
		//IStackHelper stackHelper = helpers.getStackHelper();
		List<LeaedTableRecipe> jeiRecipes = Lists.newArrayList();
		
		List<ItemStack> inputs = Lists.newArrayList();
		
		for(int inp = 0; inp <= 35; inp++) {
			
			if(inp == 14 || inp == 15 || inp == 20 || inp == 21)
				inputs.add(new ItemStack(Blocks.CHEST));
			else
				inputs.add(new ItemStack(BlockInit.LEAOP_BLOCK));
		}
		
		LeaedTableRecipe recipe = new LeaedTableRecipe(inputs, new ItemStack(BlockInit.LEA_CHEST, 3));
		jeiRecipes.add(recipe);
		
		return jeiRecipes;
	}
	
}
*/