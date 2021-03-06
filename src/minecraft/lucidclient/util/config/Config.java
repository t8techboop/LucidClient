package lucidclient.util.config;

import java.io.File;
import java.io.IOException;

import lucidclient.LucidClient;
import lucidclient.hud.mod.HudMod;

public class Config {
	
	public File configFolder = new File("LucidClient");
	public File ModsFolder = new File("LucidClient/Mods");
	
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("LucidClient/Mods/ModConfiguration.save"));
	
	public void saveModConfig() {
		
		if(!configFolder.exists()) {
			configFolder.mkdirs();
		}
		if(!ModsFolder.exists()) {
			ModsFolder.mkdirs();
		}
		
		System.out.println("saving");
		
		for(HudMod m : LucidClient.INSTANCE.hudManager.hudMods) {
			configToSave.set(m.name.toLowerCase() + " x", m.getX());
			configToSave.set(m.name.toLowerCase() + " y", m.getY());
			configToSave.set(m.name.toLowerCase() + " enabled", m.isEnabled());
		}
		
		try {
			configToSave.save();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public void loadModConfig() {

		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("LucidClient/Mods/ModConfiguration.save"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
