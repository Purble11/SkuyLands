package com.purble.skuylands.blocks.leaed_table;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;

import com.purble.skuylands.other.LeaedTableRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.world.World;

public class GuiLeaedTable extends Container implements Supplier<Map<Integer, Slot>> {

	private IInventory internal;
	public EntityPlayer player;
	public World world;
	private Map<Integer, Slot> customSlots = new HashMap<>();
	public GuiLeaedTable(World world, int x, int y, int z, EntityPlayer player) {
		this.internal = new InventoryBasic("container.leaed_table", true, 37);
		this.player = player;
		this.world = world;
		int currentX = 0;
		int currentY = 0;
		
		for(int slot = 0; slot <= 35; slot++) {
			int startX = 3;
			int endSlot = 5;
			int startY = 16;
			int spaceBetweenSlot = 18;
			currentX = currentX == 0 ? startX : currentX + spaceBetweenSlot;
			currentY = currentY == 0 ? startY : currentY;
			
			this.customSlots.put(slot, this.addSlotToContainer(new Slot(internal, slot, currentX, currentY) {
				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					
					GuiLeaedTable.this.slotChanged(this.getSlotIndex(), 0, 0, this.getStack());
				}
			}));
			
			if(currentX == startX + spaceBetweenSlot*endSlot) {
				currentY += spaceBetweenSlot;
				currentX = 0;
			}
		}
		this.customSlots.put(36, this.addSlotToContainer(new Slot(internal, 36, 192, 57) {
			@Override
			public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
				if(!GuiLeaedTable.this.world.isRemote) {
					GuiLeaedTable.this.customSlots.forEach((slotNum, slot) -> {
						if(slotNum != 36) {
							ItemStack shrinkedStack = slot.getStack().copy();
							shrinkedStack.setCount(shrinkedStack.getCount() - 1);
							slot.putStack(shrinkedStack);
							GuiLeaedTable.this.detectAndSendChanges();
							((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(GuiLeaedTable.this.windowId, slotNum, slot.getStack()));
						}
					});
				}
				
				return super.onTake(thePlayer, stack);
			}

			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}
		}));
		int si;
		int sj;
		for (si = 0; si < 3; ++si)
			for (sj = 0; sj < 9; ++sj)
				this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 40 + 8 + sj * 18, (30 + 84 + si * 18) + 10));
		for (si = 0; si < 9; ++si)
			this.addSlotToContainer(new Slot(player.inventory, si, 40 + 8 + si * 18, (30 + 142) + 10));
	}

	public GuiLeaedTable(Object world2, Object object, Object object2, Object object3, Object player2) {
		// Test constructor
	}

	public Map<Integer, Slot> get() {
		return this.customSlots;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return internal.isUsableByPlayer(player);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
			this.customSlots.get(36).putStack(ItemStack.EMPTY);
			this.clearContainer(playerIn, playerIn.world, internal);
		}
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		ItemStack hg = super.slotClick(slotId, dragType, clickTypeIn, player);
		this.inventorySlots.get(36).putStack(ItemStack.EMPTY.copy());
		this.slotChanged(slotId, 0, 0, null).copy();
		this.inventorySlots.get(36).putStack(this.slotChanged(slotId, 0, 0, null).copy());
		return hg;
	}

	public ItemStack slotChanged(int slotid, int ctype, int meta, ItemStack eventStack) {
		LeaedTableRecipes recipes = new LeaedTableRecipes();
		for (Map.Entry<Map<Integer, Item>, ItemStack> entry : recipes.getRecipes().entrySet()) {
			Map<Integer, Item> input = entry.getKey();
		    ItemStack output = entry.getValue();
			if(this.get().get(0).getStack().getItem() == input.get(0) && this.get().get(1).getStack().getItem() == input.get(1)
					&& this.get().get(2).getStack().getItem() == input.get(2) && this.get().get(3).getStack().getItem() == input.get(3)
					&& this.get().get(4).getStack().getItem() == input.get(4) && this.get().get(5).getStack().getItem() == input.get(5)
					&& this.get().get(6).getStack().getItem() == input.get(6) && this.get().get(7).getStack().getItem() == input.get(7)
					&& this.get().get(8).getStack().getItem() == input.get(8) && this.get().get(9).getStack().getItem() == input.get(9)
					&& this.get().get(10).getStack().getItem() == input.get(10) && this.get().get(11).getStack().getItem() == input.get(11)
					&& this.get().get(12).getStack().getItem() == input.get(12) && this.get().get(13).getStack().getItem() == input.get(13)
					&& this.get().get(14).getStack().getItem() == input.get(14) && this.get().get(15).getStack().getItem() == input.get(15)
					&& this.get().get(16).getStack().getItem() == input.get(16) && this.get().get(17).getStack().getItem() == input.get(17)
					&& this.get().get(18).getStack().getItem() == input.get(18) && this.get().get(19).getStack().getItem() == input.get(19)
					&& this.get().get(20).getStack().getItem() == input.get(20) && this.get().get(21).getStack().getItem() == input.get(21)
					&& this.get().get(22).getStack().getItem() == input.get(22) && this.get().get(23).getStack().getItem() == input.get(23)
					&& this.get().get(24).getStack().getItem() == input.get(24) && this.get().get(25).getStack().getItem() == input.get(25)
					&& this.get().get(26).getStack().getItem() == input.get(26) && this.get().get(27).getStack().getItem() == input.get(27)
					&& this.get().get(28).getStack().getItem() == input.get(28) && this.get().get(29).getStack().getItem() == input.get(29)
					&& this.get().get(30).getStack().getItem() == input.get(30) && this.get().get(31).getStack().getItem() == input.get(31)
					&& this.get().get(32).getStack().getItem() == input.get(32) && this.get().get(33).getStack().getItem() == input.get(33)
					&& this.get().get(34).getStack().getItem() == input.get(34) && this.get().get(35).getStack().getItem() == input.get(35)) {
				return output;//.copy();
			}
		}
		return ItemStack.EMPTY;
	}
	
}
