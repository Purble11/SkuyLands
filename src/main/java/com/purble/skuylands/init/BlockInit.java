package com.purble.skuylands.init;

import java.util.ArrayList;
import java.util.List;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.blocks.*;
import com.purble.skuylands.blocks.lea_wood.buttons.*;
import com.purble.skuylands.blocks.lea_wood.doors.LEA_DOOR;
import com.purble.skuylands.blocks.lea_wood.fences.*;
import com.purble.skuylands.blocks.lea_wood.pressure_plate.*;
import com.purble.skuylands.blocks.lea_wood.slabs.*;
import com.purble.skuylands.blocks.lea_wood.stairs.*;
import com.purble.skuylands.blocks.lea_wood.trapdoors.LEA_TRAPDOOR;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<>();
	
	//I am using .toLowerCase() cuz i am lazy

	public static final Block LEAOP_BLOCK = new LEAOP_BLOCK("LEAOP_BLOCK".toLowerCase(), Material.IRON);
	public static final Block LEA_LOG = new LEA_LOG("LEA_LOG".toLowerCase(), Material.WOOD);
	public static final Block LEA_PLANKS = new LEA_PLANKS("LEA_PLANKS".toLowerCase(), Material.WOOD);
	public static final Block LEA_LEAVES = new LEA_LEAVES("LEA_LEAVES".toLowerCase(), Material.LEAVES);
	public static final Block LEAOP_ORE = new LEAOP_ORE("LEAOP_ORE".toLowerCase(), Material.ROCK);
	public static final Block LEAOP_LORD_MINION_SPAWNER = new LEAOP_LORD_MINION_SPAWNER("LEAOP_LORD_MINION_SPAWNER".toLowerCase(), Material.ROCK);
	public static final Block LEAED_VOID = new LEAED_VOID("LEAED_VOID".toLowerCase(), Material.SPONGE);
	public static final BlockSlab LEA_SLAB_DOUBLE = new LEA_SLAB_DOUBLE("LEA_SLAB_DOUBLE".toLowerCase(), Material.WOOD, BlockInit.LEA_SLAB_HALF);
	public static final BlockSlab LEA_SLAB_HALF = new LEA_SLAB_HALF("LEA_SLAB_HALF".toLowerCase(), Material.WOOD, SkuyLands.skuylands, BlockInit.LEA_SLAB_HALF, BlockInit.LEA_SLAB_DOUBLE);
	public static final Block LEA_STAIRS = new LEA_STAIRS("LEA_STAIRS".toLowerCase(), BlockInit.LEA_PLANKS.getDefaultState(), SkuyLands.skuylands, 7, 7, SoundType.WOOD, "axe", 3);
	public static final Block LEA_FENCE = new LEA_FENCE("LEA_FENCE".toLowerCase());
	public static final Block LEA_PRESSURE_PLATE = new LEA_PRESSURE_PLATE("LEA_PRESSURE_PLATE".toLowerCase());
	public static final Block LEA_BUTTON = new LEA_BUTTON("LEA_BUTTON".toLowerCase());
	public static final Block LEA_DOOR = new LEA_DOOR("LEA_DOOR".toLowerCase());
	public static final Block LEA_TRAPDOOR = new LEA_TRAPDOOR("LEA_TRAPDOOR".toLowerCase());
	public static final Block SKUYLANDS_HOME_PORTAL = new SKUYLANDS_HOME_PORTAL("SKUYLANDS_HOME_PORTAL".toLowerCase());
	public static final Block LEA_BARK = new LEA_BARK("LEA_BARK".toLowerCase());
	public static final Block LEA_SAPLING = new LEA_SAPLING("LEA_SAPLING".toLowerCase());
	public static final Block LEAED_TABLE = new com.purble.skuylands.blocks.leaed_table.LEAED_TABLE("LEAED_TABLE".toLowerCase(), Material.IRON);
	public static final Block LEA_CHEST = new com.purble.skuylands.blocks.lea_chest.LEA_CHEST("LEA_CHEST".toLowerCase(), Material.IRON);
	public static final Block LEAOP_CROP = new LEAOP_CROP("LEAOP_CROP".toLowerCase());
	public static final Block LEA_FENCE_GATE = new com.purble.skuylands.blocks.lea_wood.fence_gate.LEA_FENCE_GATE("LEA_FENCE_GATE".toLowerCase());
	
}
