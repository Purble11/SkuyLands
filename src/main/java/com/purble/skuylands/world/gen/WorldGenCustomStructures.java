package com.purble.skuylands.world.gen;

import java.util.ArrayList;
import java.util.Random;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.util.handlers.ConfigHandler;
import com.purble.skuylands.world.gen.biomes.BiomeSkuyLands;
import com.purble.skuylands.world.gen.biomes.WorldGenStructure;
import com.purble.skuylands.world.gen.biomes.WorldGenStructure2;
import com.purble.skuylands.world.gen.biomes.WorldGenStructure3;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {

	public static final WorldGenStructure TREE = new WorldGenStructure("skuylandstree");
	public static final WorldGenStructure2 LEAOP_LORD_MINION_STRUCTURE = new WorldGenStructure2("LEAOP_LORD_MINION_STRUCTURE".toLowerCase());
	public static final WorldGenStructure3 FORGOTEN_SKUYLANDS_HOME_PORTAL = new WorldGenStructure3("FORGOTEN_SKUYLANDS_HOME_PORTAL".toLowerCase());
	public static final WorldGenStructure TREE_SKLH = new WorldGenStructure("skuylandstree");
	public static final WorldGenStructure2 LEAOP_LORD_MINION_STRUCTURE_SKLH = new WorldGenStructure2("LEAOP_LORD_MINION_STRUCTURE".toLowerCase());

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
			case 0:
				generateStructure(LEAOP_LORD_MINION_STRUCTURE, world, random, chunkX, chunkZ, 65, Blocks.GRASS, BiomeSkuyLands.class);
				generateStructure(FORGOTEN_SKUYLANDS_HOME_PORTAL, world, random, chunkX, chunkZ, 69, Blocks.GRASS, BiomeSkuyLands.class);
				generateStructure(TREE, world, random, chunkX, chunkZ, 1, Blocks.DIRT, BiomeSkuyLands.class);
				generateStructure(TREE, world, random, chunkX, chunkZ, 1, Blocks.GRASS, BiomeSkuyLands.class);
				generateStructure(TREE, world, random, chunkX, chunkZ, 1, Blocks.DIRT, BiomeSkuyLands.class);
				generateStructure(TREE, world, random, chunkX, chunkZ, 1, Blocks.GRASS, BiomeSkuyLands.class);
		}
		if(world.provider.getDimension() == ConfigHandler.SKUYLANDS_HOME) {
			generateStructure(LEAOP_LORD_MINION_STRUCTURE_SKLH, world, random, chunkX, chunkZ, 65, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
			generateStructure(TREE_SKLH, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
			generateStructure(TREE_SKLH, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
			generateStructure(TREE_SKLH, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
			generateStructure(TREE_SKLH, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
		}
	}

	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
		@SuppressWarnings("unchecked")
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX*16) + random.nextInt(15);
		int z = (chunkZ*16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT) {
			if(classesList.contains(biome)) {
				if(random.nextInt(chance) == 0) {
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y <= 10 ? -69 : y;
	}
}
