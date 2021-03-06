package lucidclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import lucidclient.LucidClient;
import lucidclient.ui.clickgui.comp.ModButton;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.util.ResourceLocation;

public class ClickGui extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		this.modButtons.add(new ModButton(210, 60, 43, mc.fontRendererObj.FONT_HEIGHT + 5, LucidClient.INSTANCE.hudManager.testMod));
		this.modButtons.add(new ModButton(280, 60, 55, mc.fontRendererObj.FONT_HEIGHT + 5, LucidClient.INSTANCE.hudManager.targetHud));
		this.modButtons.add(new ModButton(360, 60, 20, mc.fontRendererObj.FONT_HEIGHT + 5, LucidClient.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(420, 60, 60, mc.fontRendererObj.FONT_HEIGHT + 5, LucidClient.INSTANCE.hudManager.keystrokes));
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() -50, new Color(47, 49, 54, 255).getRGB());
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() -120, new Color(54, 57, 63, 255).getRGB());
		GuiInventory.drawEntityOnScreen(250, 455, 30, 0, 0, mc.thePlayer);
		this.drawCenteredString(fontRendererObj, mc.thePlayer.getName(), 320, height / 2f + 170, -1);
		
		this.drawCenteredString(fontRendererObj, "Playing " + LucidClient.INSTANCE.NAME, 332, height / 2f + 190, -1);
		
		
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	} 
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}

}
