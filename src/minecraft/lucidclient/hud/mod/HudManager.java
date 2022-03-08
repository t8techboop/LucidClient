package lucidclient.hud.mod;

import java.util.ArrayList;

import lucidclient.hud.mod.impl.FPSMod;
import lucidclient.hud.mod.impl.Keystrokes;
import lucidclient.hud.mod.impl.TargetHUD;
import lucidclient.hud.mod.impl.TestMod;

public class HudManager {
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public TestMod testMod;
	public FPSMod fps;
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
	
	public HudManager() {
		hudMods.add(testMod = new TestMod());
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
		
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
		       m.draw();
			}
		}
	}

}
