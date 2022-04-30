package com.purble.skuylands.util.handlers;

import com.purble.skuylands.util.Referance;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	
	public static ResourceLocation SKUYLANDS_CHEST_LOOT;
	
	public static void registerLootTables() {
		SKUYLANDS_CHEST_LOOT = LootTableList.register(new ResourceLocation(Referance.MOD_ID, "SKUYLANDS_CHEST_LOOT".toLowerCase()));
	}

}
