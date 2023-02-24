package com.purble.skuylands.entity.leaoplordminionarrow;

import com.purble.skuylands.SkuyLands;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
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
			if(result.entityHit instanceof EntityPlayer)
				SkuyLands.killPlayer((EntityPlayer)result.entityHit, this.thrower.getDisplayName().getUnformattedText());
			else
				SkuyLands.killEntity((EntityLivingBase)result.entityHit);
		}
	}

}
