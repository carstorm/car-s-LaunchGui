package main.launchgui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.List;

public class StartupGui extends GuiScreen {

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(0, this.width / 2 - 144, this.height / 2 + 96, 288, 20, ConfigHandler.buttonText));
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();

		drawCenteredString(this.fontRendererObj, TextHelper.YELLOW + ConfigHandler.guiTitle, this.width / 2, this.height / 2 - 100, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line1, this.width / 2, this.height / 2 - 85, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line2, this.width / 2, this.height / 2 - 70, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line3, this.width / 2, this.height / 2 - 55, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line4, this.width / 2, this.height / 2 - 40, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line5, this.width / 2, this.height / 2 - 25, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line6, this.width / 2, this.height / 2 - 10, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line7, this.width / 2, this.height / 2 + 5, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line8, this.width / 2, this.height / 2 + 20, 0xFFFFFF);
		drawCenteredString(this.fontRendererObj, ConfigHandler.line9, this.width / 2, this.height / 2 + 35, 0xFFFFFF);
		super.drawScreen(par1, par2, par3);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void actionPerformed(GuiButton button) {
		dontShowAgain();
		for (GuiButton b : (List<GuiButton>) buttonList) {
			b.enabled = false;
		}
		this.mc.displayGuiScreen(null);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		return;
	}

	private void dontShowAgain() {
		LaunchGui.logger.info("Disabling GUI...");
		ConfigHandler.manuallyChangeConfigValue("launchgui.cfg", "B:displayGuiOnLaunch", "true", "false");
	}
}