package com.purble.skuylands.entity.leaoplordminion;

import com.purble.skuylands.entity.leaoplordminionarrow.EntityLeaopLordMinionProjectile;
import com.purble.skuylands.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLeaopLordMinion extends EntityMob implements IRangedAttackMob {
	
	private final EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, 2.5F, 40, 30);

	public EntityLeaopLordMinion(World worldIn) {
		super(worldIn);
		this.setSize(width, height + 0.4F);
		this.setCombatTask();
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.setCombatTask();
		return super.onInitialSpawn(difficulty, livingdata);
	}
	
	@Override
	protected void initEntityAI() {
		// WHY DOES ECLIPSE GIVE ME ERRORS WHEN A CTRL SPACE ON NEW ENTITYAI
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0F));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
	
    protected EntityLeaopLordMinionProjectile getArrow(float p_190726_1_)
    {
        return new EntityLeaopLordMinionProjectile(this.world, this);
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
		return;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setCombatTask();
		super.readEntityFromNBT(compound);
	}
	
	private void setCombatTask() {
		if (this.world != null && !this.world.isRemote)
        {
            this.tasks.removeTask(this.aiArrowAttack);
            this.tasks.addTask(4, this.aiArrowAttack);
        }
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(999.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}
	
	@Override
	public float getEyeHeight() {
		return this.height - 0.4F;
	}
	
	@Override
	public boolean isNonBoss() {
		return false;
	}
	
	private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);
	
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundsHandler.LEAOP_LORD_MINION_DEATH;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundsHandler.LEAOP_LORD_MINION_AMBIENT;
	}
	
	/*@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundsHandler.LEAOP_LORD_MINION_HURT;
	}
	
	@Override
	protected ResourceLocation getLootTable() {
		return super.getLootTable();
	}*/

}
