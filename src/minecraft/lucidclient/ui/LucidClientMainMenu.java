package lucidclient.ui;

import java.io.IOException;
import java.awt.Color;
import java.awt.color.*;

import lucidclient.LucidClient;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class LucidClientMainMenu extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("LucidClientCapes/MainMenu.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		

		Gui.drawRect(0, 0, 225, this.height, new Color(0, 0, 0, 120).getRGB());
		GlStateManager.pushMatrix();
		//GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		//GlStateManager.translate(-(width/2f), -(height/2f), 0);
		this.drawCenteredString(fontRendererObj, LucidClient.INSTANCE.NAME, 35, height / 2f - 207, -1);

		GlStateManager.popMatrix();
		mc.getTextureManager().bindTexture(new ResourceLocation("LucidClientCapes/Update.png"));
		this.drawModalRectWithCustomSizedTexture(659, 20, 0, 0, 181, 75, 181, 75);
		Gui.drawRect(650, 10, 850, 150, new Color(0, 0, 0, 120).getRGB());
		this.drawCenteredString(fontRendererObj, LucidClient.INSTANCE.NAME + "pvp client, update notes:", 750, height / 2f - 150, -100);
		this.drawCenteredString(fontRendererObj, "created the client", 702, height / 2f - 140, -100);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 10, height / 2 - 40, "SinglePlayer"));
		this.buttonList.add(new GuiButton(2, 10, height / 2 - 15, "Online"));
		this.buttonList.add(new GuiButton(3, 10, height / 2 + 10, "Settings"));
		this.buttonList.add(new GuiButton(4, 10, height / 2 + 35, "RAGE QUIT"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if(button.id == 4) {
			mc.shutdown();
		}
		super.actionPerformed(button);
	}

}
