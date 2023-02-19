package com.purble.skuylands.items.leaed_table_recipe_book_stuff;

import java.io.IOException;
import java.util.Map;

import com.purble.skuylands.other.LeaedTableRecipes;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.purble.skuylands.blocks.leaed_table.GuiLeaedTable;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.util.Referance;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiWindowLeaedTableRecipeBook extends GuiContainer {

	LeaedTableRecipes leaedTable = new LeaedTableRecipes();
	int recipNum = 0;

	public GuiWindowLeaedTableRecipeBook(World world, int x, int y, int z, EntityPlayer entity) {
		super(new GuiLeaedTableRecipeBook(world, x, y, z, entity));
		this.xSize = 229;
		this.ySize = 111;
	}
	private static final ResourceLocation texture = new ResourceLocation(Referance.MOD_ID + ":textures/gui/leaed_table_recipe_book.png");
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		this.mc.renderEngine.bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawModalRectWithCustomSizedTexture(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		zLevel = 100.0F;
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void initGui() {
		recipNum = 0;
		super.initGui();
		this.guiLeft = (this.width - 229) / 2;
		this.guiTop = (this.height - 111) / 2;
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.guiLeft + 213, this.guiTop + 44, 15, 20, ">"));
		this.buttonList.add(new GuiButton(1, this.guiLeft + 3, this.guiTop + 44, 15, 20, "<"));
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		Map<Integer, Slot> invSlots = ((GuiLeaedTableRecipeBook)this.inventorySlots).get();

		if(button.id == 0) {
			recipNum += 1;
			/*if(invSlots.get(36).getStack().getItem() == Item.getItemFromBlock(BlockInit.LEA_CHEST)) {
				ItemStack matter = new ItemStack(ItemInit.LEAED_CHARGE_MATTER);
				ItemStack ingot = new ItemStack(ItemInit.LEAOP_INGOT);
				invSlots.get(0).putStack(matter);
				invSlots.get(1).putStack(matter);
				invSlots.get(2).putStack(matter);
				invSlots.get(3).putStack(matter);
				invSlots.get(4).putStack(matter);
				invSlots.get(5).putStack(matter);
				invSlots.get(6).putStack(matter);
				invSlots.get(7).putStack(ingot);
				invSlots.get(8).putStack(ingot);
				invSlots.get(9).putStack(ingot);
				invSlots.get(10).putStack(ingot);
				invSlots.get(11).putStack(matter);
				invSlots.get(12).putStack(matter);
				invSlots.get(13).putStack(ingot);
				invSlots.get(14).putStack(ingot);
				invSlots.get(15).putStack(ingot);
				invSlots.get(16).putStack(ingot);
				invSlots.get(17).putStack(matter);
				invSlots.get(18).putStack(matter);
				invSlots.get(19).putStack(ingot);
				invSlots.get(20).putStack(ingot);
				invSlots.get(21).putStack(ingot);
				invSlots.get(22).putStack(ingot);
				invSlots.get(23).putStack(matter);
				invSlots.get(24).putStack(matter);
				invSlots.get(25).putStack(ingot);
				invSlots.get(26).putStack(ingot);
				invSlots.get(27).putStack(ingot);
				invSlots.get(28).putStack(ingot);
				invSlots.get(29).putStack(matter);
				invSlots.get(30).putStack(matter);
				invSlots.get(31).putStack(matter);
				invSlots.get(32).putStack(matter);
				invSlots.get(33).putStack(matter);
				invSlots.get(34).putStack(matter);
				invSlots.get(35).putStack(matter);
			} else if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEAOP_SHARD) {
				ItemStack n = ItemStack.EMPTY;
				ItemStack s = new ItemStack(ItemInit.POWERED_LEAOP_SHARD);
				ItemStack t = new ItemStack(Items.STICK);
				invSlots.get(0).putStack(n);
				invSlots.get(1).putStack(n);
				invSlots.get(2).putStack(s);
				invSlots.get(3).putStack(s);
				invSlots.get(4).putStack(n);
				invSlots.get(5).putStack(n);
				invSlots.get(6).putStack(n);
				invSlots.get(7).putStack(s);
				invSlots.get(8).putStack(n);
				invSlots.get(9).putStack(s);
				invSlots.get(10).putStack(n);
				invSlots.get(11).putStack(n);
				invSlots.get(12).putStack(n);
				invSlots.get(13).putStack(n);
				invSlots.get(14).putStack(n);
				invSlots.get(15).putStack(s);
				invSlots.get(16).putStack(n);
				invSlots.get(17).putStack(n);
				invSlots.get(18).putStack(n);
				invSlots.get(19).putStack(n);
				invSlots.get(20).putStack(n);
				invSlots.get(21).putStack(t);
				invSlots.get(22).putStack(n);
				invSlots.get(23).putStack(n);
				invSlots.get(24).putStack(n);
				invSlots.get(25).putStack(n);
				invSlots.get(26).putStack(n);
				invSlots.get(27).putStack(t);
				invSlots.get(28).putStack(n);
				invSlots.get(29).putStack(n);
				invSlots.get(30).putStack(n);
				invSlots.get(31).putStack(n);
				invSlots.get(32).putStack(n);
				invSlots.get(33).putStack(t);
				invSlots.get(34).putStack(n);
				invSlots.get(35).putStack(n);
			} else if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEA_STAFF) {
				ItemStack n = ItemStack.EMPTY;
				ItemStack s = new ItemStack(ItemInit.POWERED_LEAOP_SHARD);
				ItemStack t = new ItemStack(Items.STICK);
				ItemStack b = new ItemStack(ItemInit.POWERED_LEAOPED_BOMB);
				invSlots.get(0).putStack(b);
				invSlots.get(1).putStack(n);
				invSlots.get(2).putStack(n);
				invSlots.get(3).putStack(n);
				invSlots.get(4).putStack(n);
				invSlots.get(5).putStack(n);
				invSlots.get(6).putStack(n);
				invSlots.get(7).putStack(s);
				invSlots.get(8).putStack(n);
				invSlots.get(9).putStack(n);
				invSlots.get(10).putStack(n);
				invSlots.get(11).putStack(n);
				invSlots.get(12).putStack(n);
				invSlots.get(13).putStack(n);
				invSlots.get(14).putStack(s);
				invSlots.get(15).putStack(n);
				invSlots.get(16).putStack(s);
				invSlots.get(17).putStack(n);
				invSlots.get(18).putStack(n);
				invSlots.get(19).putStack(n);
				invSlots.get(20).putStack(n);
				invSlots.get(21).putStack(s);
				invSlots.get(22).putStack(n);
				invSlots.get(23).putStack(n);
				invSlots.get(24).putStack(n);
				invSlots.get(25).putStack(n);
				invSlots.get(26).putStack(s);
				invSlots.get(27).putStack(n);
				invSlots.get(28).putStack(t);
				invSlots.get(29).putStack(n);
				invSlots.get(30).putStack(n);
				invSlots.get(31).putStack(n);
				invSlots.get(32).putStack(n);
				invSlots.get(33).putStack(n);
				invSlots.get(34).putStack(n);
				invSlots.get(35).putStack(s);
			} else if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEA_SWORD) {
				((GuiLeaedTableRecipeBook) this.inventorySlots).get().forEach((slotNum, slot) -> {
					if (slotNum == 36)
						slot.putStack(new ItemStack(leaedTable.getRecipeOutputFromId(0)));
					else
						slot.putStack(new ItemStack(leaedTable.getRecipeInputFromId(0).get(slotNum)));
				});
			}*/ 
		} else if(button.id == 1) {
			recipNum -= 1;
			/*if(invSlots.get(36).getStack().getItem() == Item.getItemFromBlock(BlockInit.LEA_CHEST)) {
				ItemStack n = ItemStack.EMPTY;
				ItemStack s = new ItemStack(ItemInit.POWERED_LEAOP_SHARD);
				ItemStack t = new ItemStack(Items.STICK);
				ItemStack b = new ItemStack(ItemInit.POWERED_LEAOPED_BOMB);
				invSlots.get(0).putStack(b);
				invSlots.get(1).putStack(n);
				invSlots.get(2).putStack(n);
				invSlots.get(3).putStack(n);
				invSlots.get(4).putStack(n);
				invSlots.get(5).putStack(n);
				invSlots.get(6).putStack(n);
				invSlots.get(7).putStack(s);
				invSlots.get(8).putStack(n);
				invSlots.get(9).putStack(n);
				invSlots.get(10).putStack(n);
				invSlots.get(11).putStack(n);
				invSlots.get(12).putStack(n);
				invSlots.get(13).putStack(n);
				invSlots.get(14).putStack(s);
				invSlots.get(15).putStack(n);
				invSlots.get(16).putStack(s);
				invSlots.get(17).putStack(n);
				invSlots.get(18).putStack(n);
				invSlots.get(19).putStack(n);
				invSlots.get(20).putStack(n);
				invSlots.get(21).putStack(s);
				invSlots.get(22).putStack(n);
				invSlots.get(23).putStack(n);
				invSlots.get(24).putStack(n);
				invSlots.get(25).putStack(n);
				invSlots.get(26).putStack(s);
				invSlots.get(27).putStack(n);
				invSlots.get(28).putStack(t);
				invSlots.get(29).putStack(n);
				invSlots.get(30).putStack(n);
				invSlots.get(31).putStack(n);
				invSlots.get(32).putStack(n);
				invSlots.get(33).putStack(n);
				invSlots.get(34).putStack(n);
				invSlots.get(35).putStack(s);
			} else if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEAOP_SHARD) {
				((GuiLeaedTableRecipeBook) this.inventorySlots).get().forEach((slotNum, slot) -> {
					if (slotNum == 36)
						slot.putStack(new ItemStack(leaedTable.getRecipeOutputFromId(leaedTable.maxRecipeId)));
					else
						slot.putStack(new ItemStack(leaedTable.getRecipeInputFromId(leaedTable.maxRecipeId).get(slotNum)));
				});
			} leaedTable.getRecipes().forEach((input, output) -> {
				if(0 <= leaedTable.recipeID) {
					((GuiLeaedTableRecipeBook) this.inventorySlots).get().forEach((slotNum, slot) -> {
						if (slotNum == 36)
							slot.putStack(new ItemStack(leaedTable.getRecipeOutputFromId(leaedTable.recipeID)));
						else
							slot.putStack(new ItemStack(leaedTable.getRecipeInputFromId(leaedTable.recipeID).get(slotNum)));
					});
					leaedTable.recipeID -= 1;
					return;
				}
			});
			if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEA_STAFF) {
				ItemStack matter = new ItemStack(ItemInit.LEAED_CHARGE_MATTER);
				ItemStack ingot = new ItemStack(ItemInit.LEAOP_INGOT);
				invSlots.get(0).putStack(matter);
				invSlots.get(1).putStack(matter);
				invSlots.get(2).putStack(matter);
				invSlots.get(3).putStack(matter);
				invSlots.get(4).putStack(matter);
				invSlots.get(5).putStack(matter);
				invSlots.get(6).putStack(matter);
				invSlots.get(7).putStack(ingot);
				invSlots.get(8).putStack(ingot);
				invSlots.get(9).putStack(ingot);
				invSlots.get(10).putStack(ingot);
				invSlots.get(11).putStack(matter);
				invSlots.get(12).putStack(matter);
				invSlots.get(13).putStack(ingot);
				invSlots.get(14).putStack(ingot);
				invSlots.get(15).putStack(ingot);
				invSlots.get(16).putStack(ingot);
				invSlots.get(17).putStack(matter);
				invSlots.get(18).putStack(matter);
				invSlots.get(19).putStack(ingot);
				invSlots.get(20).putStack(ingot);
				invSlots.get(21).putStack(ingot);
				invSlots.get(22).putStack(ingot);
				invSlots.get(23).putStack(matter);
				invSlots.get(24).putStack(matter);
				invSlots.get(25).putStack(ingot);
				invSlots.get(26).putStack(ingot);
				invSlots.get(27).putStack(ingot);
				invSlots.get(28).putStack(ingot);
				invSlots.get(29).putStack(matter);
				invSlots.get(30).putStack(matter);
				invSlots.get(31).putStack(matter);
				invSlots.get(32).putStack(matter);
				invSlots.get(33).putStack(matter);
				invSlots.get(34).putStack(matter);
				invSlots.get(35).putStack(matter);
			} else if(invSlots.get(36).getStack().getItem() == ItemInit.POWERED_LEA_SWORD) {
				ItemStack n = ItemStack.EMPTY;
				ItemStack s = new ItemStack(ItemInit.POWERED_LEAOP_SHARD);
				ItemStack t = new ItemStack(Items.STICK);
				invSlots.get(0).putStack(n);
				invSlots.get(1).putStack(n);
				invSlots.get(2).putStack(s);
				invSlots.get(3).putStack(s);
				invSlots.get(4).putStack(n);
				invSlots.get(5).putStack(n);
				invSlots.get(6).putStack(n);
				invSlots.get(7).putStack(s);
				invSlots.get(8).putStack(n);
				invSlots.get(9).putStack(s);
				invSlots.get(10).putStack(n);
				invSlots.get(11).putStack(n);
				invSlots.get(12).putStack(n);
				invSlots.get(13).putStack(n);
				invSlots.get(14).putStack(n);
				invSlots.get(15).putStack(s);
				invSlots.get(16).putStack(n);
				invSlots.get(17).putStack(n);
				invSlots.get(18).putStack(n);
				invSlots.get(19).putStack(n);
				invSlots.get(20).putStack(n);
				invSlots.get(21).putStack(t);
				invSlots.get(22).putStack(n);
				invSlots.get(23).putStack(n);
				invSlots.get(24).putStack(n);
				invSlots.get(25).putStack(n);
				invSlots.get(26).putStack(n);
				invSlots.get(27).putStack(t);
				invSlots.get(28).putStack(n);
				invSlots.get(29).putStack(n);
				invSlots.get(30).putStack(n);
				invSlots.get(31).putStack(n);
				invSlots.get(32).putStack(n);
				invSlots.get(33).putStack(t);
				invSlots.get(34).putStack(n);
				invSlots.get(35).putStack(n);
			}*/
		}

		if(recipNum > leaedTable.maxRecipeId) {
			recipNum = 0;
		}
		
		if(recipNum < 0) {
			recipNum = leaedTable.maxRecipeId;
		}
		
		leaedTable.getRecipes().forEach((input, output) -> {
			((GuiLeaedTableRecipeBook) this.inventorySlots).get().forEach((slotNum, slot) -> {
				if (slotNum == 36) {
					slot.putStack(leaedTable.getRecipeOutputFromId(recipNum));
				} else
					slot.putStack(new ItemStack(leaedTable.getRecipeInputFromId(recipNum).get(slotNum)));
			});
			return;
		});
		
		System.out.println(recipNum);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
}
