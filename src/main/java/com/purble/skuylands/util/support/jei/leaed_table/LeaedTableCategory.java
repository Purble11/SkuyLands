/*package com.purble.skuylands.util.support.jei.leaed_table;

import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.support.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;

public class LeaedTableCategory extends AbstractLeaedTableRecipeCategory<LeaedTableRecipe> {

	private final IDrawable background;
	private final String name;
	
	public LeaedTableCategory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 0, 0, 256, 201);
		name = "Leaed Table";
	}
	
	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Override
	public String getTitle() {
		return name;
	}
	
	@Override
	public String getModName() {
		return Referance.NAME;
	}
	
	@Override
	public String getUid() {
		return RecipeCategories.LEAED_TABLE;
	}
	
	public void setRecipe(IRecipeLayout recipeLayout, LeaedTableRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input0, true, 3, 16);
		stacks.init(input1, true, 3*2, 16);
		stacks.init(input2, true, 3*3, 16);
		stacks.init(input3, true, 3*4, 16);
		stacks.init(input4, true, 3*5, 16);
		stacks.init(input5, true, 3*6, 16);
		stacks.init(input6, true, 3, 16*2);
		stacks.init(input7, true, 3*2, 16*2);
		stacks.init(input8, true, 3*3, 16*2);
		stacks.init(input9, true, 3*4, 16*2);
		stacks.init(input10, true, 3*5, 16*2);
		stacks.init(input11, true, 3*6, 16*2);
		stacks.init(input12, true, 3, 16*3);
		stacks.init(input13, true, 3*2, 16*3);
		stacks.init(input14, true, 3*3, 16*3);
		stacks.init(input15, true, 3*4, 16*3);
		stacks.init(input16, true, 3*5, 16*3);
		stacks.init(input17, true, 3*6, 16*3);
		stacks.init(input18, true, 3, 16*4);
		stacks.init(input19, true, 3*2, 16*4);
		stacks.init(input20, true, 3*3, 16*4);
		stacks.init(input21, true, 3*4, 16*4);
		stacks.init(input22, true, 3*5, 16*4);
		stacks.init(input23, true, 3*6, 16*4);
		stacks.init(input24, true, 3, 16*5);
		stacks.init(input25, true, 3*2, 16*5);
		stacks.init(input26, true, 3*3, 16*5);
		stacks.init(input27, true, 3*4, 16*5);
		stacks.init(input28, true, 3*5, 16*5);
		stacks.init(input29, true, 3*6, 16*5);
		stacks.init(input30, true, 3, 16*6);
		stacks.init(input31, true, 3*2, 16*6);
		stacks.init(input32, true, 3*3, 16*6);
		stacks.init(input33, true, 3*4, 16*6);
		stacks.init(input34, true, 3*5, 16*6);
		stacks.init(input35, true, 3*6, 16*6);
		stacks.init(output, false, 191, 60);
		stacks.set(ingredients);
	};
	
}
*/