package com.purble.skuylands.items.leaed_table_recipe_book_stuff;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;
import com.purble.skuylands.init.BlockInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuiLeaedTableRecipeBook extends Container implements Supplier<Map<Integer, Slot>> {

	private IInventory internal;
	public EntityPlayer player;
	public World world;
	private Map<Integer, Slot> customSlots = new HashMap<>();
	public GuiLeaedTableRecipeBook(World world, int x, int y, int z, EntityPlayer player) {
		this.internal = new InventoryBasic("container.leaed_table_recipe_book", true, 37);
		this.player = player;
		this.world = world;
		int currentX = 0;
		int currentY = 0;
		
		for(int slot = 0; slot <= 35; slot++) {
			int startX = 18;
			int endSlot = 5;
			int startY = 3;
			int spaceBetweenSlot = 18;
			currentX = currentX == 0 ? startX : currentX + spaceBetweenSlot;
			currentY = currentY == 0 ? startY : currentY;
			
			this.customSlots.put(slot, this.addSlotToContainer(new Slot(internal, slot, currentX, currentY) {
				@Override
				public boolean canTakeStack(EntityPlayer playerIn) {
					return false;
				}

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			
			if(currentX == startX + spaceBetweenSlot*endSlot) {
				currentY += spaceBetweenSlot;
				currentX = 0;
			}
		}
		this.customSlots.put(36, this.addSlotToContainer(new Slot(internal, 36, 192, 44) {
			@Override
			public boolean canTakeStack(EntityPlayer playerIn) {
				return false;
			}

			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}
		}));

		ItemStack stack1 = new ItemStack(BlockInit.LEAOP_BLOCK);
		ItemStack stack2 = new ItemStack(Blocks.CHEST);
		this.customSlots.get(0).putStack(stack1);
		this.customSlots.get(1).putStack(stack1);
		this.customSlots.get(2).putStack(stack1);
		this.customSlots.get(3).putStack(stack1);
		this.customSlots.get(4).putStack(stack1);
		this.customSlots.get(5).putStack(stack1);
		this.customSlots.get(6).putStack(stack1);
		this.customSlots.get(7).putStack(stack1);
		this.customSlots.get(8).putStack(stack1);
		this.customSlots.get(9).putStack(stack1);
		this.customSlots.get(10).putStack(stack1);
		this.customSlots.get(11).putStack(stack1);
		this.customSlots.get(12).putStack(stack1);
		this.customSlots.get(13).putStack(stack1);
		this.customSlots.get(14).putStack(stack2);
		this.customSlots.get(15).putStack(stack2);
		this.customSlots.get(16).putStack(stack1);
		this.customSlots.get(17).putStack(stack1);
		this.customSlots.get(18).putStack(stack1);
		this.customSlots.get(19).putStack(stack1);
		this.customSlots.get(20).putStack(stack2);
		this.customSlots.get(21).putStack(stack2);
		this.customSlots.get(22).putStack(stack1);
		this.customSlots.get(23).putStack(stack1);
		this.customSlots.get(24).putStack(stack1);
		this.customSlots.get(25).putStack(stack1);
		this.customSlots.get(26).putStack(stack1);
		this.customSlots.get(27).putStack(stack1);
		this.customSlots.get(28).putStack(stack1);
		this.customSlots.get(29).putStack(stack1);
		this.customSlots.get(30).putStack(stack1);
		this.customSlots.get(31).putStack(stack1);
		this.customSlots.get(32).putStack(stack1);
		this.customSlots.get(33).putStack(stack1);
		this.customSlots.get(34).putStack(stack1);
		this.customSlots.get(35).putStack(stack1);
		this.customSlots.get(36).putStack(new ItemStack(BlockInit.LEA_CHEST, 3));
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return internal.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		return ItemStack.EMPTY;
	}

	@Override
	protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
		return false;
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
			this.customSlots.forEach((slotnum, slot) -> { slot.putStack(ItemStack.EMPTY); });
			this.clearContainer(playerIn, playerIn.world, internal);
		}
	}
	
}
