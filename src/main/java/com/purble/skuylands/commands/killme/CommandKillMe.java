package com.purble.skuylands.commands.killme;

import com.purble.skuylands.util.handlers.ConfigHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandKillMe extends CommandBase {

	@Override
	public String getName() {
		return "killme";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "killme";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			if(ConfigHandler.TOGGLE_KILLME) {
				new KillMeCommand((EntityPlayer) sender);
			} else {
				sender.sendMessage(new TextComponentString("This command has been disabled in the config file"));
			}
		} else {
			sender.sendMessage(new TextComponentString("As console you cant do that command"));
		}
	}

}
