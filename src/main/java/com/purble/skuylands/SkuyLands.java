package com.purble.skuylands;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.purble.skuylands.entity.leaoplordminion.EntityLeaopLordMinion;
import com.purble.skuylands.init.BlockInit;
import com.purble.skuylands.proxy.CommonProxy;
import com.purble.skuylands.tabs.SkuyLandsTab;
import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.handlers.ConfigHandler;
import com.purble.skuylands.util.handlers.DimTeleporter;
import com.purble.skuylands.util.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Referance.MOD_ID, version = Referance.VERSION, name = Referance.NAME)//, dependencies = SkuyLands.DEPENDENCIES)
public class SkuyLands {
	
	public static File config;
	//protected static final String DEPENDENCIES = "required-after:jei";
	
	@Instance
	public static SkuyLands instance;

	public static final CreativeTabs skuylands = new SkuyLandsTab("skuylands");
	
	@SidedProxy(clientSide = Referance.CLIENT_PROXY_CLASS, serverSide = Referance.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegistryHandler.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RegistryHandler.postInit();
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event) {
		RegistryHandler.serverRegistries(event);
	}
	
	public static void killPlayer(EntityPlayer player, String playerKillerName) {
		//make so if player has op armor on it kills the other hitter
		if(!player.getEntityWorld().isRemote) {
			InventoryPlayer inv = player.inventory;
			
			ArrayList<String> deathMessage = new ArrayList<>();
			deathMessage.add(" was sent to heaven by");
			deathMessage.add(" was slained by");
			deathMessage.add(" was OOF-ed by");
			deathMessage.add("'s damage was too little for");
			deathMessage.add(" got squished like an bug by");
			deathMessage.add(" was sent to the sky by");
			deathMessage.add(" was turned into dust by");
			deathMessage.add(" was spammed with hits to death by");
			
			inv.dropAllItems();
			inv.clear();
			if(player.dimension != 0) {
				try {
					DimTeleporter.teleportToDimension(player, 0, player.getBedLocation().getX() + 0.5F, player.getBedLocation().getY(), (double) player.getBedLocation().getZ() + 0.5F);
				} catch (NullPointerException e) {
					DimTeleporter.teleportToDimension(player, 0, player.world.getSpawnPoint().getX() + 0.5F, calculatePosHeight(player.world, player.world.getSpawnPoint().getX(), player.world.getSpawnPoint().getZ()), (double) player.world.getSpawnPoint().getZ() + 0.5F);
				}
			} else {
				try {
					player.setPositionAndUpdate(player.getBedLocation().getX() + 0.5F, player.getBedLocation().getY(), (double) player.getBedLocation().getZ() + 0.5F);
				} catch (NullPointerException e) {
					player.setPositionAndUpdate(player.world.getSpawnPoint().getX() + 0.5F, calculatePosHeight(player.world, player.world.getSpawnPoint().getX(), player.world.getSpawnPoint().getZ()), (double) player.world.getSpawnPoint().getZ() + 0.5F);
				}
			}
		/*	player.setPosition((double) player.world.provider.getSpawnPoint().getX() + 0.5F,
					player.world.provider.getSpawnPoint().getY(), 
					(double) player.world.provider.getSpawnPoint().getZ() + 0.5F);*/
			//try {
			Minecraft.getMinecraft().getIntegratedServer().getPlayerList().sendMessage(new TextComponentString(player.getDisplayNameString() + deathMessage.get(new Random().nextInt(deathMessage.size())) + " " + playerKillerName));
			/*} catch (NullPointerException e) {
				player.sendMessage(new TextComponentString(player.getDisplayNameString() + deathMessage.get(new Random().nextInt(deathMessage.size())) + " " + playerKillerName));
			}*/
			player.setHealth(-69420.0F);
		}
	}
	
	private static int calculatePosHeight(World world, int x, int z) {
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block != Blocks.AIR;
		}
		
		return y;
	}
	
	public static void killEntity(EntityLivingBase entityIn) {
		try {
			if(entityIn instanceof EntityLeaopLordMinion)
				System.out.println("Cant Kill EntityLeaopLordMinion");
			else
				entityIn.onKillCommand();
		} catch (NullPointerException err) {
			System.out.println("Could not kill entity succssfully");
		}
	} 
	
	public static void changeDimToSkuyLandsHome(EntityPlayer player) {
		DimTeleporter.teleportToDimension(player, ConfigHandler.SKUYLANDS_HOME, 0, 75, 3000);
		World world = player.getEntityWorld();
		world.setBlockState(player.getPosition().add(1, -1, 0), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 0, 0), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 1, 0), BlockInit.SKUYLANDS_HOME_PORTAL.getDefaultState());
		//half block part
		Block firstHalf = BlockInit.LEA_PLANKS;
		world.setBlockState(player.getPosition().add(1, -2, 0), firstHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, -2, 1), firstHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, -2, -1), firstHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, -1, 1), firstHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, -1, -1), firstHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 0, -1), firstHalf.getDefaultState());
		//other half block part
		Block otherHalf = BlockInit.LEA_BARK;
		world.setBlockState(player.getPosition().add(1, 1, -1), otherHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 2, -1), otherHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 2, 0), otherHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 2, 1), otherHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 1, 1), otherHalf.getDefaultState());
		world.setBlockState(player.getPosition().add(1, 0, 1), otherHalf.getDefaultState());
		
		world.setBlockState(player.getPosition().down(), BlockInit.LEAED_VOID.getDefaultState());
		//NVM Dimension Changing is Difficult
		/*if(!player.world.isRemote) {
			player.dimension = ConfigHandler.SKUYLANDS_HOME;
			player.setPositionAndUpdate(0, 25, 0);
			BlockPos startBlock = player.getPosition().add(0, -1, -5);
			IBlockState floorBlockState = Blocks.BEDROCK.getDefaultState();
			for(int i = 0; i <= 25; i++) {
				player.world.setBlockState(startBlock.add(0, 0, i), floorBlockState);
				player.world.setBlockState(startBlock.add(1, 0, i), floorBlockState);
				player.world.setBlockState(startBlock.add(2, 0, i), floorBlockState);
				player.world.setBlockState(startBlock.add(-1, 0, i), floorBlockState);
				player.world.setBlockState(startBlock.add(-2, 0, i), floorBlockState);
				//First Air Layer
				player.world.setBlockState(startBlock.add(0, 1, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(1, 1, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(2, 1, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-1, 1, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-2, 1, i), Blocks.AIR.getDefaultState(), 3);
				//Second Air Layer
				player.world.setBlockState(startBlock.add(0, 2, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(1, 2, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(2, 2, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-1, 2, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-2, 2, i), Blocks.AIR.getDefaultState(), 3);
				//Third Air Layer
				player.world.setBlockState(startBlock.add(0, 3, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(1, 3, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(2, 3, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-1, 3, i), Blocks.AIR.getDefaultState(), 3);
				player.world.setBlockState(startBlock.add(-2, 3, i), Blocks.AIR.getDefaultState(), 3);
			}
		}*/
	}
	
	/*private static void teleportEntityToCoordinates(Entity teleportingEntity, CommandBase.CoordinateArg argX, CommandBase.CoordinateArg argY, CommandBase.CoordinateArg argZ, CommandBase.CoordinateArg argYaw, CommandBase.CoordinateArg argPitch)
    {
        if (teleportingEntity instanceof EntityPlayerMP)
        {
            Set<SPacketPlayerPosLook.EnumFlags> set = EnumSet.<SPacketPlayerPosLook.EnumFlags>noneOf(SPacketPlayerPosLook.EnumFlags.class);

            if (argX.isRelative())
            {
                set.add(SPacketPlayerPosLook.EnumFlags.X);
            }

            if (argY.isRelative())
            {
                set.add(SPacketPlayerPosLook.EnumFlags.Y);
            }

            if (argZ.isRelative())
            {
                set.add(SPacketPlayerPosLook.EnumFlags.Z);
            }

            if (argPitch.isRelative())
            {
                set.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }

            if (argYaw.isRelative())
            {
                set.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }

            float f = (float)argYaw.getAmount();

            if (!argYaw.isRelative())
            {
                f = MathHelper.wrapDegrees(f);
            }

            float f1 = (float)argPitch.getAmount();

            if (!argPitch.isRelative())
            {
                f1 = MathHelper.wrapDegrees(f1);
            }

            teleportingEntity.dismountRidingEntity();
            ((EntityPlayerMP)teleportingEntity).connection.setPlayerLocation(argX.getAmount(), argY.getAmount(), argZ.getAmount(), f, f1, set);
            teleportingEntity.setRotationYawHead(f);
        }
        else
        {
            float f2 = (float)MathHelper.wrapDegrees(argYaw.getResult());
            float f3 = (float)MathHelper.wrapDegrees(argPitch.getResult());
            f3 = MathHelper.clamp(f3, -90.0F, 90.0F);
            teleportingEntity.setLocationAndAngles(argX.getResult(), argY.getResult(), argZ.getResult(), f2, f3);
            teleportingEntity.setRotationYawHead(f2);
        }

        if (!(teleportingEntity instanceof EntityLivingBase) || !((EntityLivingBase)teleportingEntity).isElytraFlying())
        {
            teleportingEntity.motionY = 0.0D;
            teleportingEntity.onGround = true;
        }
    }*/
	
	public static SkuyLands getInstance() {
		return instance;
	}
}
