package lucidclient.mod;

import java.util.ArrayList;

import lucidclient.mod.impl.TestMod;

public class ModManager {
	
	public ArrayList<Mod> mods;
	public TestMod testMod;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		//MISC
		mods.add(testMod = new TestMod());
	}

}
