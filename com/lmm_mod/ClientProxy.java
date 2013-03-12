package lmm_mod;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderThings() {
		// Client Registrations.
		MinecraftForgeClient.preloadTexture("/Blocks.png");
		MinecraftForgeClient.preloadTexture("/Items.png");
		
	}

}
