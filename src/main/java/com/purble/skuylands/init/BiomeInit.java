package com.purble.skuylands.init;

import com.purble.skuylands.world.gen.biomes.BiomeSkuyLands;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	public static final Biome SKUYLANDS = new BiomeSkuyLands();
	
	public static void registerBiomes() {
		initBiome(SKUYLANDS, "SkuyLands".toLowerCase(), BiomeType.WARM, Type.FOREST);
		
	}
	
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 1));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
