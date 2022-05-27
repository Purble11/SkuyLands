package com.purble.skuylands.entity.leapet;

import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.entity.leaoplordminionarrow.EntityLeaopLordMinionProjectile;
import com.purble.skuylands.init.ItemInit;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLeaPet extends EntityTameable implements IRangedAttackMob {

	private final EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, 2.5F, 40, 30);
	
	public EntityLeaPet(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
		this.setCombatTask();
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setCombatTask();
		super.readEntityFromNBT(compound);
	}
	
	private void setCombatTask() {
		if (this.world != null && !this.world.isRemote) {
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(5, this.aiArrowAttack);
		}
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.setCombatTask();
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityLeaopLordMinion.class, false));
	}
	
	@Override
	public boolean isSitting() {
		setSitting(false);
		return false;
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if(player.getHeldItem(hand).getItem() == ItemInit.LEAOPED_APPLE && !this.isTamed()) {
			player.getHeldItem(hand).shrink(1);
			
			player.world.spawnParticle(EnumParticleTypes.HEART, this.getPosition().getX(), this.getPosition().getY()+2, this.getPosition().getZ(), 1, 1, 1, 2);
			
			if(rand.nextInt(100) <= 11) {
				this.setTamedBy(player);
				if(!this.world.isRemote)
					player.sendMessage(new TextComponentString("Tamed!"));
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0F);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityLeaopLordMinionProjectile entityarrow = this.getArrow(distanceFactor);
		double d0 = target.posX - this.posX;
		double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
		double d2 = target.posZ - this.posZ;
		double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
		entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 1.0F);
		this.world.spawnEntity(entityarrow);
	}
	
	protected EntityLeaopLordMinionProjectile getArrow(float p_190726_1_) {
		return new EntityLeaopLordMinionProjectile(this.world, this);
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
		return;
	}
	
}
