package com.purble.skuylands.other;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import java.util.Arrays;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class LeaedTableRecipes {
	
	Map<Map<Integer, Item>, ItemStack> recipes = new HashMap<>();
	Map<Integer, Map<Integer, Item>> recipesInputId = new HashMap<>();
	Map<Integer, ItemStack> recipesOutputId = new HashMap<>();
	String[] recipesOutputAmountId = {};
	public int recipeID = 0;
	public int maxRecipeId = -1;



	public LeaedTableRecipes() {
		addRecipe(0, new String[] { 
				"sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block",
				"sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block",
				"sl:leaop_block", "sl:leaop_block", "mc:chest", "mc:chest", "sl:leaop_block", "sl:leaop_block",
				"sl:leaop_block", "sl:leaop_block", "mc:chest", "mc:chest", "sl:leaop_block", "sl:leaop_block",
				"sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block",
				"sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block", "sl:leaop_block" }, new ItemStack(BlockInit.LEA_CHEST, 3));
		addRecipe(1, new String[] { 
				"sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter",
				"sl:leaed_charge_matter", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaed_charge_matter",
				"sl:leaed_charge_matter", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaed_charge_matter",
				"sl:leaed_charge_matter", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaed_charge_matter",
				"sl:leaed_charge_matter", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaop_ingot", "sl:leaed_charge_matter",
				"sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter", "sl:leaed_charge_matter" }, new ItemStack(ItemInit.POWERED_LEAOP_SHARD, 3));
		addRecipe(2, new String[] { 
				"mc:air", "mc:air", "sl:powered_leaop_shard", "sl:powered_leaop_shard", "mc:air", "mc:air",
				"mc:air", "sl:powered_leaop_shard", "mc:air", "sl:powered_leaop_shard", "mc:air", "mc:air",
				"mc:air", "mc:air", "mc:air", "sl:powered_leaop_shard", "mc:air", "mc:air",
				"mc:air", "mc:air", "mc:air", "mc:stick", "mc:air", "mc:air",
				"mc:air", "mc:air", "mc:air", "mc:stick", "mc:air", "mc:air",
				"mc:air", "mc:air", "mc:air", "mc:stick", "mc:air", "mc:air" }, new ItemStack(ItemInit.POWERED_LEA_STAFF, 2));
	}

	public Map<Integer, Item> getRecipeInputFromId(int id) {
		return recipesInputId.get(id);
	}

	public ItemStack getRecipeOutputFromId(int id) {
		return recipesOutputId.get(id);
	}
	
	/*public Integer getRecipeOutputAmountFromId(int id) {
		for (int i = 0; i < recipesOutputAmountId.length; i++) {
			System.out.println(recipesOutputAmountId[i].split("_")[1]);
		    if(Integer.parseInt(recipesOutputAmountId[i].split("_")[0]) == id) {
				System.out.println(recipesOutputAmountId[i].split("_")[1]);
		    	return Integer.parseInt(recipesOutputAmountId[i].split("_")[1]);
		    }
		}
		
		return 1;
	}*/

	private void addRecipe(int id, String[] input, ItemStack output) {
		Map<Integer, Item> inputCoverted = new HashMap<Integer, Item>();

		for(int i = 0; i <= 35; i++) {
			if(input[i].startsWith("mc:"))
				inputCoverted.put(i, Item.getByNameOrId(input[i].replaceAll("mc:", "minecraft:")));
			else if(input[i].startsWith("sl:"))
				inputCoverted.put(i, Item.getByNameOrId(input[i].replaceAll("sl:", "skuylands:")));
		}
		
		maxRecipeId += 1;
		/*String[] newArray = Arrays.copyOf(recipesOutputAmountId, recipesOutputAmountId.length + 1);

		newArray[newArray.length - 1] = id + "_" + amount;

		recipesOutputAmountId = newArray;
		*/
		recipes.put(inputCoverted, output);
		recipesInputId.put(id, inputCoverted);
		recipesOutputId.put(id, output);
	}
	
	public Map<Map<Integer, Item>, ItemStack> getRecipes() {
		return recipes;
	}
	
}
