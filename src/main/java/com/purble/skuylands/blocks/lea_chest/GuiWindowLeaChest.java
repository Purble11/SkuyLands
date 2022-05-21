package com.purble.skuylands.blocks.lea_chest;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.purble.skuylands.util.Referance;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiWindowLeaChest extends GuiContainer{

	public GuiWindowLeaChest(World world, int x, int y, int z, EntityPlayer entity) {
		super(new GuiLeaChest(world, x, y, z, entity));
		this.xSize = 315;
		this.ySize = 242;
	}
	private static final ResourceLocation texture = new ResourceLocation(Referance.MOD_ID+":textures/gui/lea_chest.png");
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		this.mc.renderEngine.bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawModalRectWithCustomSizedTexture(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		zLevel = 100.0F;
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void initGui() {
		super.initGui();
		this.guiLeft = (this.width - 315) / 2;
		this.guiTop = (this.height - 242) / 2;
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
