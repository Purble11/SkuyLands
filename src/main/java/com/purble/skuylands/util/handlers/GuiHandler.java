package com.purble.skuylands.util.handlers;

import com.purble.skuylands.blocks.lea_chest.GuiLeaChest;
import com.purble.skuylands.blocks.lea_chest.GuiWindowLeaChest;
import com.purble.skuylands.blocks.leaed_table.GuiLeaedTable;
import com.purble.skuylands.blocks.leaed_table.GuiWindowLeaedTable;
import com.purble.skuylands.items.leaed_table_recipe_book_stuff.GuiLeaedTableRecipeBook;
import com.purble.skuylands.items.leaed_table_recipe_book_stuff.GuiWindowLeaedTableRecipeBook;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ConfigHandler.GUI_LEAED_TABLE) {
			return new GuiLeaedTable(world, x, y, z, player);
		}
		if(ID == ConfigHandler.GUI_LEA_CHEST) {
			return new GuiLeaChest(world, x, y, z, player);
		}
		if(ID == ConfigHandler.GUI_LEAED_TABLE_RECIPE_BOOK) {
			return new GuiLeaedTableRecipeBook(world, x, y, z, player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ConfigHandler.GUI_LEAED_TABLE) {
			return new GuiWindowLeaedTable(world, x, y, z, player);
		}
		if(ID == ConfigHandler.GUI_LEA_CHEST) {
			return new GuiWindowLeaChest(world, x, y, z, player);
		}
		if(ID == ConfigHandler.GUI_LEAED_TABLE_RECIPE_BOOK) {
			return new GuiWindowLeaedTableRecipeBook(world, x, y, z, player);
		}
		return null;
	}

}
