package com.purble.skuylands.entity;

import com.purble.skuylands.SkuyLands;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
				if(result.entityHit instanceof EntityPlayer) {
					SkuyLands.killPlayer((EntityPlayer)result.entityHit, "Leaoped Orb");
					return;
				}
				SkuyLands.killEntity((EntityLivingBase)result.entityHit);
			}
		}
	}

}
