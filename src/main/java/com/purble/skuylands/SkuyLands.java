package com.purble.skuylands;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.purble.skuylands.proxy.CommonProxy;
import com.purble.skuylands.tabs.SkuyLandsTab;
import com.purble.skuylands.util.Referance;
import com.purble.skuylands.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Referance.MOD_ID, version = Referance.VERSION, name = Referance.NAME)
public class SkuyLands {
	
	public static File config;
	
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
			
			inv.dropAllItems();
			inv.clear();
			try {
				((EntityPlayerMP)player).connection.setPlayerLocation((double) player.getBedLocation().getX() + 0.5F, player.getBedLocation().getY(), (double) player.getBedLocation().getZ() + 0.5F, 1.0F, 1.0F);
			} catch (NullPointerException e) {
				((EntityPlayerMP)player).connection.setPlayerLocation((double) player.world.getSpawnPoint().getX() + 0.5F, player.world.getSpawnPoint().getY(), (double) player.world.getSpawnPoint().getZ() + 0.5F, 1.0F, 1.0F);
			}
		/*	player.setPosition((double) player.world.provider.getSpawnPoint().getX() + 0.5F,
					player.world.provider.getSpawnPoint().getY(), 
					(double) player.world.provider.getSpawnPoint().getZ() + 0.5F);*/
			try {
				player.getServer().getPlayerList().sendMessage(new TextComponentString(player.getDisplayNameString() + deathMessage.get(new Random().nextInt(deathMessage.size())) + " " + playerKillerName));
			} catch (NullPointerException e) {
				player.sendMessage(new TextComponentString(player.getDisplayNameString() + deathMessage.get(new Random().nextInt(deathMessage.size())) + " " + playerKillerName));
			}
			player.setHealth(-69420.0F);
		}
	}
	
	public static void killEntity(EntityLivingBase entity) {
		entity.setHealth(-69420.0F);
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
	
	public SkuyLands getInstance() {
		return instance;
	}
}
