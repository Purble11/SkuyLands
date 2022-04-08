package com.purble.skuylands.world.gen.biomes;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeDecoratorSkuyLands extends BiomeDecorator {
	
	@Override
	protected void genDecorations(Biome biomeIn, World worldIn, Random random) {
		super.genDecorations(biomeIn, worldIn, random);
	}
	
	@Override
	protected void generateOres(World worldIn, Random random) {
		super.generateOres(worldIn, random);
	}

}
