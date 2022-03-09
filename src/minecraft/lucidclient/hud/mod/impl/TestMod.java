package lucidclient.hud.mod.impl;

import java.awt.Color;

import lucidclient.hud.mod.HudMod;
import lucidclient.settings.BooleanSetting;
import lucidclient.settings.ModeSetting;
import net.minecraft.client.gui.Gui;

public class TestMod extends HudMod {

	BooleanSetting test = new BooleanSetting("test", true);
	ModeSetting testMode = new ModeSetting("Test Mode", "Mode1", "Mode1", "Mode2", "Mode3");
	
	public TestMod() {
		super("TestMod", 5, 5);
		this.addSettings(test,testMode);

	}
	
	@Override
	public void draw() {
		
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString(name, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {

		fr.drawString(name, getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
}
