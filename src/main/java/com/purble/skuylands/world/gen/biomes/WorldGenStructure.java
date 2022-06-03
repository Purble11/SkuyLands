package com.purble.skuylands.world.gen.biomes;

import java.util.Random;

import com.purble.skuylands.util.IStructure;
import com.purble.skuylands.util.Referance;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class WorldGenStructure extends WorldGenerator implements IStructure {

	public static String structureName;
	
	public WorldGenStructure(String name) {
		this.structureName = name;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return false;
	}
	
	public static void generateStructure(World world, BlockPos pos) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Referance.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);
		
		int offsetX = template.getSize().getX() / 2;
		int offsetZ = template.getSize().getZ() / 2;
		
		if(template != null) {
			IBlockState state = world.getBlockState(pos.add(-offsetX, 0, -offsetZ));
			world.notifyBlockUpdate(pos.add(-offsetX, 0, -offsetZ), state, state, 3);
			template.addBlocksToWorld(world, pos.add(-offsetX, 0, -offsetZ), setting);
		}
	}

}
