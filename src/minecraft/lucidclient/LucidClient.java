package lucidclient;

import lucidclient.event.EventManager;
import lucidclient.event.EventTarget;
import lucidclient.event.impl.ClientTick;
import lucidclient.hud.HUDConfigScreen;
import lucidclient.hud.mod.HudManager;
import lucidclient.mod.ModManager;
import lucidclient.mod.util.SessionChanger;
import lucidclient.ui.clickgui.ClickGui;
import lucidclient.util.config.Config;
import net.minecraft.client.Minecraft;

public class LucidClient {
	public String NAME = "Lucid Client ", VERSION = "1.0 ", AUTHOR = "Thomas404";  
	public static LucidClient INSTANCE = new LucidClient();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public Config config;
	public ModManager modManager;
	public HudManager hudManager;
	
	public void startup() {
		eventManager = new EventManager();
		config = new Config();
		modManager = new ModManager();
		hudManager = new HudManager();
		
		config.loadModConfig();
		
		//SessionChanger.getInstance().setUserOffline("Terminator0011");		
		System.out.println(NAME + VERSION + AUTHOR);

		eventManager.register(this);
	}
	
	public void shutdown() {
		System.out.println("Shutting down");
		
		config.saveModConfig();


		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.TEST_MOD.isPressed()) {
			modManager.testMod.toggle();
	}
		if(mc.gameSettings.HUB_COONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
	}
		if(mc.gameSettings.CLICK_GUI.isPressed()) {
			mc.displayGuiScreen(new ClickGui());
	}
	
   
   }

}
