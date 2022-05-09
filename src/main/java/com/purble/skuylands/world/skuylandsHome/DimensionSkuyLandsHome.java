package com.purble.skuylands.world.skuylandsHome;

import com.purble.skuylands.init.DimensionInit;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionSkuyLandsHome extends WorldProvider {

	@Override
	protected void init() {
		this.biomeProvider = new BiomeProviderSkuyLandsHome(this.world.getSeed());
	}
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionInit.SKUYLANDS_HOME;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new SkuyLandsHomeGen(this.world, true, this.world.getSeed(), this.world.getSpawnPoint());
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.5F;
		
		for(int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	
}
