package lmm_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "LetsMod_Mod", name = "LetsMod Mod", version = "In-Dev 1.0")
@NetworkMod(
		channels = { "LetsMod_Mod" },
		clientSideRequired = true,
		serverSideRequired = false,
		packetHandler = PacketHandler.class )

public class LetsMod_Mod {
	
	private static int dechanterBlockID;
	
	@Instance
	public static LetsMod_Mod instance;

	@SidedProxy(clientSide = "lmm_mod.ClientProxy", serverSide = "lmm_mod.CommonProxy")
	public static CommonProxy proxy;
	
	
	// Preload of items and blocks.
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		
		// Getting the Configuration file
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Blocks
		dechanterBlockID = config.getBlock("DechanterBlock", 1000,
				"Default is 1000").getInt();
		
		//Items
		
		// Saving configuration!
		config.save();
	}
	
	
	// Blocks fields
	public final static Block dechanterBlock = new BlockDechanter(dechanterBlockID, 1, Material.ground);
	
	// Item fields
	
	
	// Loading the mod!
	@Init
	public void load(FMLInitializationEvent event) {
		// ItemStacks
		ItemStack dirtStack = new ItemStack(Block.dirt);
		ItemStack dechanterStack = new ItemStack(dechanterBlock);
		
		// Blocks
		GameRegistry.registerBlock(dechanterBlock, "Ace_Dechanter");
		
		// Items
		
		// Language
		LanguageRegistry.addName(dechanterBlock, "Dechanter");
		
		// Recipes
		GameRegistry.addShapelessRecipe(dechanterStack, dirtStack);
		
		proxy.registerRenderers();
		

	}
	
}
