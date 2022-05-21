/*package com.purble.skuylands.util.support.jei;

import java.util.IllegalFormatException;

import com.purble.skuylands.blocks.leaed_table.GuiLeaedTable;
import com.purble.skuylands.blocks.leaed_table.GuiWindowLeaedTable;
import com.purble.skuylands.util.support.jei.leaed_table.LeaedTableCategory;
import com.purble.skuylands.util.support.jei.leaed_table.LeaedTableRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
//@JEIPlugin
//Not Working WIP, Very Sad :(
//Help me fix it pls
Error top Section:
net.minecraftforge.fml.common.LoaderExceptionModCrash: Caught exception from Just Enough Items (jei)
Caused by: net.minecraft.util.ReportedException: Registering texture

Error CausedBy Section:
Caused by: java.lang.IllegalAccessError: tried to access method net.minecraft.client.renderer.texture.TextureMap.initMissingImage()V from class mezz.jei.gui.textures.JeiTextureMap
	at mezz.jei.gui.textures.JeiTextureMap.loadTexture(JeiTextureMap.java:43)

and No there isnt any classes refering to the mod (This or SkuyLands)

public class JEICompat implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new LeaedTableCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry) {
		//final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(LeaedTableRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.LEAED_TABLE);
		registry.addRecipeClickArea(GuiWindowLeaedTable.class, 3, 17, 0, 50, RecipeCategories.LEAED_TABLE);
		recipeTransfer.addRecipeTransferHandler(GuiLeaedTable.class, RecipeCategories.LEAED_TABLE, 0, 35, 37, 36);
	}
	
	public static String translateToLocale(String key) {
		if(I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	
	public static String translateToLocalFormatted(String key, Object... format) {
		String s = translateToLocale(key);
		
		try {
			return String.format(s, format);
		} catch (IllegalFormatException e) {
			return "Format error: "+s;
		}
	}
	
}
*/