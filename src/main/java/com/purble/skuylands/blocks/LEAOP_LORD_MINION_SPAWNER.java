package com.purble.skuylands.blocks;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LEAOP_LORD_MINION_SPAWNER extends Block {
	// Add model to skuylands:models/block/ and add its structure
	
	public static final AxisAlignedBB LEAOP_LORD_MINION_SPAWNER = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

	public LEAOP_LORD_MINION_SPAWNER(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SkuyLands.skuylands);
		this.setHardness(4.5F);
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		this.setResistance(this.blockHardness);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return LEAOP_LORD_MINION_SPAWNER;
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		super.onBlockClicked(worldIn, pos, playerIn);
		playerIn.swingArm(EnumHand.MAIN_HAND);
		if(playerIn.getHeldItemMainhand().getItem() == ItemInit.UNKNOWN_LEAOP_KEY) {
			EntityLeaopLordMinion entityLeaopLordMinion = new EntityLeaopLordMinion(worldIn);
			entityLeaopLordMinion.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
			worldIn.spawnEntity(entityLeaopLordMinion);
			worldIn.setBlockToAir(pos);
			
			playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
			
			return;
		}
		
		playerIn.sendMessage(new TextComponentString("&cYou dont have the correct item in your hand!"));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		playerIn.swingArm(EnumHand.MAIN_HAND);
		if(playerIn.getHeldItemMainhand().getItem() == ItemInit.UNKNOWN_LEAOP_KEY) {
			EntityLeaopLordMinion entityLeaopLordMinion = new EntityLeaopLordMinion(worldIn);
			entityLeaopLordMinion.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
			worldIn.spawnEntity(entityLeaopLordMinion);
			worldIn.setBlockToAir(pos);
			
			playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
			
			return true;
		}
		
		playerIn.sendMessage(new TextComponentString("&cYou dont have the correct item in your hand!"));
		return true;
	}
	
}
