package com.purble.skuylands.entity;

import java.util.Random;

import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityLeaopArrow extends EntityArrow {

	public EntityLeaopArrow(World worldIn) {
		super(worldIn);
	}

	public EntityLeaopArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityLeaopArrow(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ItemInit.LEAOP_ARROW);
	}
	
	@Override
	public void shoot(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy) {
		/*if(!shooter.isCreatureType(EnumCreatureType.MONSTER, false) && ((EntityPlayer)shooter).getHeldItemMainhand() != new ItemStack(ItemInit.LEAOP_BOW) && ((EntityPlayer)shooter).getHeldItemOffhand() != new ItemStack(ItemInit.LEAOP_BOW)) {
			BlockPos pos = shooter.getPosition();
			dropItem(ItemInit.LEAOP_ARROW, 1);
		} else {*/
		float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
		//}
	}
	
	@Override
	protected void arrowHit(EntityLivingBase living) {
		super.arrowHit(living);
		living.setHealth(living.getHealth() - 30);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.world.isRemote) {
			if(this.inGround) {
				if(this.timeInGround % 5 == 0) {
					this.spawnParticles(1);
				}
			} else {
				this.spawnParticles(2);
			}
		}
	}	
	
	private void spawnParticles(int particleCount) {
		Random rand = new Random();
		int i = rand.nextInt(15);
		double d0 = (double)(i >> 16 & 255) / 255.0D;
		double d1 = (double)(i >> 8 & 255) / 255.0D;
		double d2 = (double)(i >> 0 & 255) / 255.0D;
		for(int j = 0; j < particleCount; j++) {
			this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width,
					this.posY + this.rand.nextDouble() * (double)this.height, 
					this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, d0, d1, d2);
		}
	}

}
