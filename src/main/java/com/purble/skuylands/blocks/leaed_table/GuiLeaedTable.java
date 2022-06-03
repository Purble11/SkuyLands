package com.purble.skuylands.blocks.leaed_table;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
				public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
					GuiLeaedTable.this.slotChanged(this.getSlotIndex(), 1, 0, stack);
					
					return super.onTake(thePlayer, stack);
				}
				
				@Override
				public void onSlotChanged() {
					super.onSlotChanged();
					
					GuiLeaedTable.this.slotChanged(0, 0, 0, null);
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
				GuiLeaedTable.this.slotChanged(this.getSlotIndex(), 1, 0, stack);
				
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

	public Map<Integer, Slot> get() {
		return customSlots;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return internal.isUsableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 37) {
				if (!this.mergeItemStack(itemstack1, 37, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(itemstack1, itemstack);
			} else if (!this.mergeItemStack(itemstack1, 0, 37, false)) {
				if (index < 37 + 27) {
					if (!this.mergeItemStack(itemstack1, 37 + 27, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.mergeItemStack(itemstack1, 37, 37 + 27, false)) {
						return ItemStack.EMPTY;
					}
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
		boolean flag = false;
		int i = startIndex;
		if (reverseDirection) {
			i = endIndex - 1;
		}
		if (stack.isStackable()) {
			while (!stack.isEmpty()) {
				if (reverseDirection) {
					if (i < startIndex) {
						break;
					}
				} else if (i >= endIndex) {
					break;
				}
				Slot slot = this.inventorySlots.get(i);
				ItemStack itemstack = slot.getStack();
				if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem()
						&& (!stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata())
						&& ItemStack.areItemStackTagsEqual(stack, itemstack)) {
					int j = itemstack.getCount() + stack.getCount();
					int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
					if (j <= maxSize) {
						stack.setCount(0);
						itemstack.setCount(j);
						slot.putStack(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						stack.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.putStack(itemstack);
						flag = true;
					}
				}
				if (reverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!stack.isEmpty()) {
			if (reverseDirection) {
				i = endIndex - 1;
			} else {
				i = startIndex;
			}
			while (true) {
				if (reverseDirection) {
					if (i < startIndex) {
						break;
					}
				} else if (i >= endIndex) {
					break;
				}
				Slot slot1 = this.inventorySlots.get(i);
				ItemStack itemstack1 = slot1.getStack();
				if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
					if (stack.getCount() > slot1.getSlotStackLimit()) {
						slot1.putStack(stack.splitStack(slot1.getSlotStackLimit()));
					} else {
						slot1.putStack(stack.splitStack(stack.getCount()));
					}
					slot1.onSlotChanged();
					flag = true;
					break;
				}
				if (reverseDirection) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
			this.customSlots.get(36).putStack(ItemStack.EMPTY);
			this.clearContainer(playerIn, playerIn.world, internal);
		}
	}

	public void slotChanged(int slotid, int ctype, int meta, ItemStack eventStack) {
		if(!this.world.isRemote) {
			if(slotid == 36) {
				this.customSlots.forEach((slotNum, slot) -> {
					if(slotNum != 36) {
						ItemStack shrinkedStack = slot.getStack().copy();
						shrinkedStack.setCount(shrinkedStack.getCount() - 1);
						slot.putStack(shrinkedStack);
						this.detectAndSendChanges();
						((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, slot.getStack()));
					}
				});
			}
			
			this.customSlots.forEach((slotNum, slot) -> {
				if(slotNum == 36) {
					slot.putStack(getRecipeItem());
					this.detectAndSendChanges();
					((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, getRecipeItem()));
				}
			});
		}
	}
	
	private ItemStack getRecipeItem() {
		Map<Integer, Item> slots = new HashMap<>();
		this.customSlots.forEach((idk, slot) -> {
			slots.put(slot.getSlotIndex(), slot.getStack().getItem());
		});
		
		if(isChestRecipe(slots)) return new ItemStack(BlockInit.LEA_CHEST, 3);
		if(isStaff(slots)) return new ItemStack(ItemInit.POWERED_LEA_STAFF);
		if(isShard(slots)) return new ItemStack(ItemInit.POWERED_LEAOP_SHARD, 2);
		return ItemStack.EMPTY;
	}
	
	private boolean isChestRecipe(Map<Integer, Item> items) {
		Item firstItem = Item.getItemFromBlock(BlockInit.LEAOP_BLOCK);
		Item secondItem = Item.getItemFromBlock(Blocks.CHEST);
		if(items.get(0) == firstItem && items.get(1) == firstItem 
				&& items.get(2) == firstItem && items.get(3) == firstItem 
				&& items.get(4) == firstItem && items.get(5) == firstItem 
				&& items.get(6) == firstItem && items.get(7) == firstItem 
				&& items.get(8) == firstItem && items.get(9) == firstItem 
				&& items.get(10) == firstItem && items.get(11) == firstItem 
				&& items.get(12) == firstItem && items.get(13) == firstItem 
				&& items.get(14) == secondItem && items.get(15) == secondItem 
				&& items.get(16) == firstItem && items.get(17) == firstItem 
				&& items.get(18) == firstItem && items.get(19) == firstItem 
				&& items.get(20) == secondItem && items.get(21) == secondItem 
				&& items.get(22) == firstItem && items.get(23) == firstItem 
				&& items.get(24) == firstItem && items.get(25) == firstItem 
				&& items.get(26) == firstItem && items.get(27) == firstItem 
				&& items.get(28) == firstItem && items.get(29) == firstItem 
				&& items.get(30) == firstItem && items.get(31) == firstItem 
				&& items.get(32) == firstItem && items.get(33) == firstItem 
				&& items.get(34) == firstItem && items.get(35) == firstItem) return true;
		return false;
	}
	
	private boolean isStaff(Map<Integer, Item> items) {
		Item firstItem = Items.AIR;
		Item secondItem = ItemInit.POWERED_LEAOP_SHARD;
		Item thirdItem = Items.STICK;
		if(items.get(0) == firstItem && items.get(1) == firstItem 
				&& items.get(2) == secondItem && items.get(3) == secondItem 
				&& items.get(4) == firstItem && items.get(5) == firstItem 
				&& items.get(6) == firstItem && items.get(7) == secondItem 
				&& items.get(8) == firstItem && items.get(9) == secondItem 
				&& items.get(10) == firstItem && items.get(11) == firstItem 
				&& items.get(12) == firstItem && items.get(13) == firstItem 
				&& items.get(14) == firstItem && items.get(15) == secondItem 
				&& items.get(16) == firstItem && items.get(17) == firstItem 
				&& items.get(18) == firstItem && items.get(19) == firstItem 
				&& items.get(20) == firstItem && items.get(21) == thirdItem 
				&& items.get(22) == firstItem && items.get(23) == firstItem 
				&& items.get(24) == firstItem && items.get(25) == firstItem 
				&& items.get(26) == firstItem && items.get(27) == thirdItem 
				&& items.get(28) == firstItem && items.get(29) == firstItem 
				&& items.get(30) == firstItem && items.get(31) == firstItem 
				&& items.get(32) == firstItem && items.get(33) == thirdItem 
				&& items.get(34) == firstItem && items.get(35) == firstItem) return true;
		return false;
	}
	

	
	private boolean isShard(Map<Integer, Item> items) {
		Item firstItem = ItemInit.LEAED_CHARGE_MATTER;
		Item secondItem = ItemInit.LEAOP_INGOT;
		if(items.get(0) == firstItem && items.get(1) == firstItem 
				&& items.get(2) == firstItem && items.get(3) == firstItem 
				&& items.get(4) == firstItem && items.get(5) == firstItem 
				&& items.get(6) == firstItem && items.get(7) == secondItem 
				&& items.get(8) == secondItem && items.get(9) == secondItem 
				&& items.get(10) == secondItem && items.get(11) == firstItem 
				&& items.get(12) == firstItem && items.get(13) == secondItem 
				&& items.get(14) == secondItem && items.get(15) == secondItem 
				&& items.get(16) == secondItem && items.get(17) == firstItem 
				&& items.get(18) == firstItem && items.get(19) == secondItem 
				&& items.get(20) == secondItem && items.get(21) == secondItem 
				&& items.get(22) == secondItem && items.get(23) == firstItem 
				&& items.get(24) == firstItem && items.get(25) == secondItem 
				&& items.get(26) == secondItem && items.get(27) == secondItem 
				&& items.get(28) == secondItem && items.get(29) == firstItem 
				&& items.get(30) == firstItem && items.get(31) == firstItem 
				&& items.get(32) == firstItem && items.get(33) == firstItem 
				&& items.get(34) == firstItem && items.get(35) == firstItem) return true;
		return false;
	}
	
}
