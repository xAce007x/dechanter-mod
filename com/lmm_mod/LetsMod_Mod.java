package lmm_mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "LetsMod_Mod", name = "LetsMod Mod", version = "In-Dev 1.0")
@NetworkMod(
		channels = { "LetsMod_Mod" },
		clientSideRequired = true,
		serverSideRequired = false,
		packetHandler = PacketHandler.class )

public class LetsMod_Mod {
	@Instance
	public static LetsMod_Mod instance;

	@SidedProxy(clientSide = "lmm_mod.CommonProxy", serverSide = "lmm_mod.CommonProxy")
	public static CommonProxy proxy;
	
	@Init
	public void load() {

	}
	
}
