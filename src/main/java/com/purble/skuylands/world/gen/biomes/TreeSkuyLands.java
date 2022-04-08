package com.purble.skuylands.world.gen.biomes;

import java.util.Random;

import com.purble.skuylands.init.BlockInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class TreeSkuyLands extends WorldGenAbstractTree {

	public static final IBlockState LOG = BlockInit.LEA_LOG.getDefaultState();
	public static final IBlockState LEAVES = BlockInit.LEA_LEAVES.getDefaultState();
	
	private int minHeight;
	
	public TreeSkuyLands() {
		super(false);
		this.minHeight = 7;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = this.minHeight + rand.nextInt(3);
		boolean flag = true;
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for(int yPos = y; yPos <= y + 1 + height; yPos++) {
			int b0 = 2;
			if(yPos == y) b0 = 1;
			if(yPos >= y + 1 + height - 2) b0 = 2;
			
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			
			for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++) {
				for(int zPos = z - b0; zPos <- z + b0 && flag; zPos++) {
					if(yPos >= 0 && yPos < world.getHeight() ) {
						if(!this.isReplaceable(world, new BlockPos(xPos, yPos, zPos))) {
							flag = false;
						}
					} else {
						flag = false;
					}
				}
			}
		}
		
		if(!flag) {
			return false;
		} else {
			BlockPos down = pos.down();
			IBlockState state = world.getBlockState(down);

			if(y < world.getHeight() - height - 1) {
				for(int logHeight = 0; logHeight < height; logHeight++) {
					BlockPos up = pos.up(logHeight);
					IBlockState logState = world.getBlockState(up);
					
					if(logState.getBlock().isAir(logState, world, up) || logState.getBlock().isLeaves(logState, world, up)) {
						this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
						y = pos.up(logHeight).getY();
					}
				}
				
				for(int yPos = y - 3 + height; yPos <= y + height; yPos++) {
					int b1 = yPos - (y + height);
					int b2 = 1 - b1 / 2;
					
					for(int xPos = x - b2; xPos <= x + b2; xPos++) {
						int b3 = xPos - x;
						for(int zPos = z - b2; zPos <= z + b2; zPos++) {
							int b4 = zPos - z;
							if(Math.abs(b3) != b2 || Math.abs(b4) != b2 || rand.nextInt(2) != 0 && b1 != 0) {
								BlockPos treePos = new BlockPos(xPos, yPos, zPos);
								IBlockState treeState = world.getBlockState(treePos);
								if(treeState.getBlock().isAir(treeState, world, treePos) || treeState.getBlock().isAir(treeState, world, treePos)) {
									this.setBlockAndNotifyAdequately(world, treePos, LEAVES);
									int leafBranches = 16;
									int leafLevel = 5;
									while(true) {
										if(leafBranches == -1) leafBranches = 16;
										
										if(leafLevel == -1) {
											break;
										} else {
											int xLeaf = rand.nextInt(5);
											int zLeaf = rand.nextInt(5);
											while(true) {
												if(zLeaf < 5 && xLeaf < 5) {
													xLeaf = rand.nextInt(5);
													zLeaf = rand.nextInt(5);
												} else {
													break;
												}
											}
											
											BlockPos aboveLeaf = new BlockPos(xLeaf, leafLevel + 1, zLeaf);
											if(world.getBlockState(aboveLeaf).getMaterial() != Material.AIR) {
												leafBranches = leafBranches - 1;
												this.setBlockAndNotifyAdequately(world, treePos.add(xLeaf, leafLevel, zLeaf), LEAVES);
												if(leafBranches == -1) {
													leafLevel = leafLevel - 1;
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	
}
