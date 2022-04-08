package com.purble.skuylands.commands.killme;

import com.purble.skuylands.SkuyLands;

import net.minecraft.entity.player.EntityPlayer;

public class KillMeCommand {

	public KillMeCommand(EntityPlayer player) {
		SkuyLands.killPlayer(player, player.getDisplayNameString());
	}

}
