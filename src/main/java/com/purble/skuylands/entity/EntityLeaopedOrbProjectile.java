package com.purble.skuylands.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLeaopedOrbProjectile extends EntityThrowable {

	public EntityLeaopedOrbProjectile(World worldIn) {
		super(worldIn);
	}

	public EntityLeaopedOrbProjectile(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityLeaopedOrbProjectile(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if(!this.world.isRemote) {
			setDead();
			if(result.entityHit instanceof EntityLivingBase) {
				((EntityLivingBase)result.entityHit).setHealth(((EntityLivingBase)result.entityHit).getHealth() - 72);
			}
		}
	}

}
