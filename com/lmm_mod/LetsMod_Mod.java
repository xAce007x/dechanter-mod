package lmm_mod;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "LetsMod Mod", name = "LetsMod_Mod", version = "In-Dev 1.0")
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
	
}
