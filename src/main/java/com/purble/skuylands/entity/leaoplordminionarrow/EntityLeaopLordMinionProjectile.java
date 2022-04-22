package com.purble.skuylands.entity.leaoplordminionarrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityLeaopLordMinionProjectile extends EntityThrowable {

	public EntityLeaopLordMinionProjectile(World worldIn) {
		super(worldIn);
	}

	public EntityLeaopLordMinionProjectile(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityLeaopLordMinionProjectile(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if(!this.world.isRemote) {
			setDead();
			if(result.entityHit instanceof EntityLivingBase) {
				((EntityLivingBase)result.entityHit).attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), 54.4F);
			}
		}
	}

}
