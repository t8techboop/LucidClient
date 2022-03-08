package lucidclient.mod.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {
	
	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("Terminator0011")) {
			return true;
		}else if(entitylivingbaseIn.getName().equals("kiboplayzyt")) {
			return true;
		} else return false;
		
		
	}

}
