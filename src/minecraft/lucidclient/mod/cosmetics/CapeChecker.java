package lucidclient.mod.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {
	
	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("Terminator0011")) {
			return true;
		}else if(entitylivingbaseIn.getName().equals("DrWhovian")) {
			return true;
		}else if(entitylivingbaseIn.getName().equals("johnnyy290")) {
			return true;
		} else return false;
		
		
	}

}
