package com.purble.skuylands.blocks.lea_chest;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiLeaChest extends Container implements Supplier<Map<Integer, Slot>> {

	private IInventory internal;
	private Map<Integer, Slot> customSlots = new HashMap<>();
	public World world;
	private int x;
	private int y;
	private int z;
	public BlockPos pos;
	public GuiLeaChest(World world, int x, int y, int z, EntityPlayer player) {
		this.internal = new InventoryBasic("container.lea_chest", true, 135);
		this.world = world;
		this.x = x;
		this.y = y;
		this.x = z;
		this.pos = new BlockPos(this.x, this.y, this.z);
		TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
		if (ent instanceof IInventory)
			this.internal = (IInventory) ent;
		int currentX = 0;
		int currentY = 0;
		
		for(int slot = 0; slot <= 134; slot++) {
			int startX = 27;
			int endRowSlot = 14;
			int startY = 2;
			int spaceBetweenSlot = 18;
			currentX = currentX == 0 ? startX : currentX + spaceBetweenSlot;
			currentY = currentY == 0 ? startY : currentY;
			
			this.customSlots.put(slot, this.addSlotToContainer(new Slot(internal, slot, currentX, currentY) {
			}));
			
			if(currentX == startX + spaceBetweenSlot*endRowSlot) {
				currentY += spaceBetweenSlot;
				currentX = 0;
			}
		}
		int si;
		int sj;
		for (si = 0; si < 3; ++si)
			for (sj = 0; sj < 9; ++sj)
				this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 69 + 8 + sj * 18, 80 + 84 + si * 18));
		for (si = 0; si < 9; ++si)
			this.addSlotToContainer(new Slot(player.inventory, si, 69 + 8 + si * 18, 80 + 142));
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
			if (index < 1) {
				if (!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(itemstack1, itemstack);
			} else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
				if (index < 1 + 27) {
					if (!this.mergeItemStack(itemstack1, 1 + 27, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.mergeItemStack(itemstack1, 1, 1 + 27, false)) {
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
		this.world.playSound(this.x, this.y, this.z, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
		if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
			this.clearContainer(playerIn, playerIn.world, internal);
		}
	}
	
}
