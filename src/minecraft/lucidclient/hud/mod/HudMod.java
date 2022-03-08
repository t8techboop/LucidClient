package lucidclient.hud.mod;

import java.awt.Color;

import lucidclient.LucidClient;
import lucidclient.hud.DraggableComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HudMod {

	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public String name;
	public boolean enabled = true;
	public DraggableComponent drag;
	
	public int x, y;

	public HudMod(String name, int x, int y) {
		this.name = name;
		
		try {
			this.x = (int) LucidClient.INSTANCE.config.config.get(name + " x");
			this.y = (int) LucidClient.INSTANCE.config.config.get(name + " y");
			this.setEnabled((boolean) LucidClient.INSTANCE.config.config.get(name + " enabled"));
		}catch (NullPointerException e) {
			e.printStackTrace();
			this.x = x;
			this.y = y;
			this.enabled = false;
			
		}
		
		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
	}
	
	//�
	
	public int getWidth() {
		return 50;
	}
	
	
	public int getHeight() {
		return 50;
	}
	
	public void draw() {
		
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();		
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		this.setEnabled(!enabled);

	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
