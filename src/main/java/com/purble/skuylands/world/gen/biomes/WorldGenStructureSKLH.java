package com.purble.skuylands.world.gen.biomes;

import java.util.Random;

import com.purble.skuylands.util.IStructureSKLH;
import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenStructureSKLH extends WorldGenerator implements IStructureSKLH {

	public static String structureName;
	
	public WorldGenStructureSKLH(String name) {
		this.structureName = name;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return false;
	}
	
	public static void generateStructure(World world, BlockPos pos) {
		try {
			MinecraftServer mcServer = world.getMinecraftServer();
			TemplateManager manager = worldServer.getStructureTemplateManager();
			ResourceLocation location = new ResourceLocation(Referance.MOD_ID, structureName);
			Template template = manager.get(mcServer, location);
			
			if(template != null) {
				if(world.provider.getDimension() == ConfigHandler.SKUYLANDS_HOME || ConfigHandler.SKUYLANDS_HOME == world.provider.getDimension()) {
					IBlockState state = world.getBlockState(pos);
					world.notifyBlockUpdate(pos, state, state, 3);
					template.addBlocksToWorld(world, pos, setting);
				}
			}
		} catch (NullPointerException e) {
		}
	}

}
