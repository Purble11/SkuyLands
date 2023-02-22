package com.purble.skuylands.blocks.leaed_table;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Supplier;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import com.purble.skuylands.other.LeaedTableRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.world.World;

public class GuiLeaedTable extends Container implements Supplier<Map<Integer, Slot>> {

	private IInventory internal;
	public EntityPlayer player;
	public World world;
	private ItemStack currOutput = ItemStack.EMPTY;
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
	
	/*@Override
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
	}*/

	/*@Override
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
	}*/

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
		System.out.println(this.slotChanged(slotId, 0, 0, null).copy());
		this.inventorySlots.get(36).putStack(this.slotChanged(slotId, 0, 0, null).copy());
		return hg;
	}
	
	@Override
	public void updateProgressBar(int id, int data) {
		// TODO Auto-generated method stub
		super.updateProgressBar(id, data);
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
				//this.get().get(36).putStack(new ItemStack(output));
				//System.out.println(output);
				//slot.putStack(output);
				//this.detectAndSendChanges();
				//((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, output));
				/*boolean is1countItem = !(output.getItem() instanceof ItemBlock) && (output.getCount() == 1);
				if(output.getItem() instanceof ItemBlock) {
					System.out.println("1");
					//((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, output));
					slot.putStack(output.copy());
					this.detectAndSendChanges();
					this.internal
				} else if(is1countItem) {
					System.out.println("2");
					slot.putStack(output.copy());
					this.detectAndSendChanges();
					//((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, output));
				} else {
					System.out.println("3");
					slot.putStack(output.copy());
					//((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, output));
					this.detectAndSendChanges();
				}*/
				System.out.println("yes");
				System.out.println("yes");
				System.out.println("yes");
				System.out.println("yes");
				return output;//.copy();
				//this.inventorySlots.get(36).putStack(output.copy());
				//slot.putStack(output.copy());
				//this.detectAndSendChanges();
				//((EntityPlayerMP)player).connection.sendPacket(new SPacketSetSlot(this.windowId, slotNum, output.copy()));
				//this.putStackInSlot(36, output.copy());
			}
		}
		return ItemStack.EMPTY;
	}
	
	/*public ItemStack getRecipeItem(Map<Integer, Slot> customSlots) {
		Map<Integer, Item> slots = new HashMap<>();
		customSlots.forEach((idk, slot) -> {
			slots.put(slot.getSlotIndex(), slot.getStack().getItem());
		});
		
		if(isChestRecipe(slots)) return new ItemStack(BlockInit.LEA_CHEST, 3);
		if(isStaff(slots)) return new ItemStack(ItemInit.POWERED_LEA_STAFF);
		if(isShard(slots)) return new ItemStack(ItemInit.POWERED_LEAOP_SHARD, 2);
		if(isSword(slots)) return new ItemStack(ItemInit.POWERED_LEA_SWORD);
		return ItemStack.EMPTY;
	}
	
	private boolean isChestRecipe(Map<Integer, Item> items) {
		Item firstItem = Item.getItemFromBlock(BlockInit.LEAOP_BLOCK);
		Item secondItem = Item.getItemFromBlock(Blocks.CHEST);
		return items.get(0) == firstItem && items.get(1) == firstItem 
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
				&& items.get(34) == firstItem && items.get(35) == firstItem;
	}
	
	private boolean isStaff(Map<Integer, Item> items) {
		Item firstItem = Items.AIR;
		Item secondItem = ItemInit.POWERED_LEAOP_SHARD;
		Item thirdItem = Items.STICK;
		return items.get(0) == firstItem && items.get(1) == firstItem 
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
				&& items.get(34) == firstItem && items.get(35) == firstItem;
	}
	
	private boolean isShard(Map<Integer, Item> items) {
		Item firstItem = ItemInit.LEAED_CHARGE_MATTER;
		Item secondItem = ItemInit.LEAOP_INGOT;
		return items.get(0) == firstItem && items.get(1) == firstItem 
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
				&& items.get(34) == firstItem && items.get(35) == firstItem;
	}
	
	private boolean isSword(Map<Integer, Item> items) {
		Item firstItem = Items.AIR;
		Item secondItem = ItemInit.POWERED_LEAOP_SHARD;
		Item thirdItem = Items.STICK;
		Item fourthItem = ItemInit.POWERED_LEAOPED_BOMB;
		return items.get(0) == fourthItem && items.get(1) == firstItem 
				&& items.get(2) == firstItem && items.get(3) == firstItem 
				&& items.get(4) == firstItem && items.get(5) == firstItem 
				&& items.get(6) == firstItem && items.get(7) == secondItem 
				&& items.get(8) == firstItem && items.get(9) == firstItem 
				&& items.get(10) == firstItem && items.get(11) == firstItem 
				&& items.get(12) == firstItem && items.get(13) == firstItem 
				&& items.get(14) == secondItem && items.get(15) == firstItem 
				&& items.get(16) == secondItem && items.get(17) == firstItem 
				&& items.get(18) == firstItem && items.get(19) == firstItem 
				&& items.get(20) == firstItem && items.get(21) == secondItem 
				&& items.get(22) == firstItem && items.get(23) == firstItem 
				&& items.get(24) == firstItem && items.get(25) == firstItem 
				&& items.get(26) == secondItem && items.get(27) == firstItem 
				&& items.get(28) == thirdItem && items.get(29) == firstItem 
				&& items.get(30) == firstItem && items.get(31) == firstItem 
				&& items.get(32) == firstItem && items.get(33) == firstItem 
				&& items.get(34) == firstItem && items.get(35) == secondItem;
	}*/
	
}
