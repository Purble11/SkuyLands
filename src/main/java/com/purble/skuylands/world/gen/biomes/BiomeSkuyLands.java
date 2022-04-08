package com.purble.skuylands.world.gen.biomes;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class BiomeSkuyLands extends Biome {

	//protected static final WorldGenAbstractTree TREE = new TreeSkuyLands();
	
	public BiomeSkuyLands() {
		super(new BiomeProperties("SkuyLands").setRainfall(0.5F).setBaseHeight(0.1F).setWaterColor(8847359).setHeightVariation(0.2F).setTemperature(0.5F));
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getStateFromMeta(0);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 4;
		decorator.mushroomsPerChunk = 0;
		decorator.bigMushroomsPerChunk = 0;
		decorator.reedsPerChunk = 0;
		decorator.cactiPerChunk = 0;
		decorator.sandPatchesPerChunk = 0;
		decorator.gravelPatchesPerChunk = 0;
		Random rand = new Random();
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 65535;
	}
	
	/*@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return TREE;
	}*/

}
