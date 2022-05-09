package com.purble.skuylands.world.gen;

import java.util.ArrayList;
import java.util.Random;

import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.world.gen.biomes.BiomeSkuyLands;
import com.purble.skuylands.world.gen.biomes.WorldGenStructureSKLH;
import com.purble.skuylands.world.gen.biomes.WorldGenStructureSKLH2;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructuresSKLH implements IWorldGenerator {

	public static final WorldGenStructureSKLH TREE = new WorldGenStructureSKLH("skuylandstree");
	public static final WorldGenStructureSKLH2 LEAOP_LORD_MINION_STRUCTURE = new WorldGenStructureSKLH2("LEAOP_LORD_MINION_STRUCTURE".toLowerCase());

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		generateStructure(LEAOP_LORD_MINION_STRUCTURE, world, random, chunkX, chunkZ, 65, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
		generateStructure(TREE, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
		generateStructure(TREE, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
		generateStructure(TREE, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
		generateStructure(TREE, world, random, chunkX, chunkZ, 1, BlockInit.LEAED_VOID, BiomeSkuyLands.class);
	}

	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
		@SuppressWarnings("unchecked")
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX*16) + random.nextInt(15);
		int z = (chunkZ*16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x, y, z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(classesList.contains(biome)) {
			if(random.nextInt(chance) == 0) {
				generator.generate(world, random, pos);
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
