package com.purble.skuylands.init;

import java.util.List;

import com.purble.skuylands.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<>();
	
	//I am using .toLowerCase() cuz i am lazy

	public static final Block LEAOP_BLOCK = new LEAOP_BLOCK("LEAOP_BLOCK".toLowerCase(), Material.IRON);
	public static final Block LEA_LOG = new LEA_LOG("LEA_LOG".toLowerCase(), Material.WOOD);
	public static final Block LEA_PLANKS = new LEA_PLANKS("LEA_PLANKS".toLowerCase(), Material.WOOD);
	public static final Block LEA_LEAVES = new LEA_LEAVES("LEA_LEAVES".toLowerCase(), Material.LEAVES);
	public static final Block LEAOP_ORE = new LEAOP_ORE("LEAOP_ORE".toLowerCase(), Material.ROCK);
	public static final Block LEAOP_LORD_MINION_SPAWNER = new LEAOP_LORD_MINION_SPAWNER("LEAOP_LORD_MINION_SPAWNER".toLowerCase(), Material.ROCK);
	//public static final Block LEAED_TABLE = new com.purble.skuylands.blocks.leaed_table.LEAED_TABLE("LEAED_TABLE".toLowerCase(), Material.IRON);
}
