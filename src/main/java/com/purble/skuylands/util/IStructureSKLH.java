package com.purble.skuylands.util;

import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructureSKLH {
	public static final WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(ConfigHandler.SKUYLANDS_HOME) != null ? 
			FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(ConfigHandler.SKUYLANDS_HOME) : 
			FMLClientHandler.instance().getServer().getWorld(ConfigHandler.SKUYLANDS_HOME);
	public static final PlacementSettings setting = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}
