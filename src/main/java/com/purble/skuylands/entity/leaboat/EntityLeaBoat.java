package com.purble.skuylands.entity.leaboat;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityLeaBoat extends EntityBoat {

	public EntityLeaBoat(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityLeaBoat(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public Item getItemBoat() {
		return ItemInit.LEA_BOAT;
	}

}
