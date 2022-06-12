package com.purble.skuylands.items;

import com.purble.skuylands.SkuyLands;
import com.purble.skuylands.init.ItemInit;
import com.purble.skuylands.init.PotionInit;
import com.purble.skuylands.particles.PoweredRingParticle;
import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class POWERED_LEAOPED_BOMB extends Item {

	public POWERED_LEAOPED_BOMB(String mctag) {
		setUnlocalizedName(mctag);
		setRegistryName(mctag);
		setCreativeTab(SkuyLands.skuylands);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		spawnParticle(worldIn, playerIn);
		playerIn.getHeldItem(handIn).shrink(1);
		worldIn.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(playerIn.posX, 0, playerIn.posZ, playerIn.posX + 1, 257, playerIn.posZ + 1).grow(5)).forEach(ent -> {
			if(ent != playerIn) {
				ent.addPotionEffect(new PotionEffect(PotionInit.POWERED_THROWN_AWAY_EFFECT, 1));
			}
		});
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	@SideOnly(Side.CLIENT)
	public void spawnParticle(World worldIn, EntityPlayer playerIn) {
		PoweredRingParticle effect = (PoweredRingParticle) new PoweredRingParticle.Factory().createParticle(ConfigHandler.PARTICLE_POWERED_RING, worldIn, playerIn.getPosition().getX(), playerIn.getPosition().up().getY(), playerIn.getPosition().getZ(), 0, 0, 0, 0);
		
		Minecraft.getMinecraft().effectRenderer.addEffect(effect);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		return onItemRightClick(worldIn, player, hand).getType();
	}
	
}
