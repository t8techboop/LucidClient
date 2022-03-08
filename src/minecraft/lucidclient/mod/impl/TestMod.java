package lucidclient.mod.impl;

import lucidclient.mod.Category;
import lucidclient.mod.Mod;

public class TestMod extends Mod{

	public TestMod() {
		super("TestMod", "Test Mod", Category.MISC);
		
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("Starting up mod");
	}

}
