package lmm_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
	
	
	// Blocks
	public final static Block dechanterBlock = new BlockDechanter(1000, 1, Material.ground);
	
	@Instance
	public static LetsMod_Mod instance;

	@SidedProxy(clientSide = "lmm_mod.CommonProxy", serverSide = "lmm_mod.CommonProxy")
	public static CommonProxy proxy;
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		// ItemStacks
		ItemStack dirtStack = new ItemStack(Block.dirt);
		ItemStack dechanterStack = new ItemStack(dechanterBlock);
		// ItemStack diamondStack = new ItemStack(Item.diamond, 64);
		
		// Blocks
		GameRegistry.registerBlock(dechanterBlock, "Ace_Dechanter");
		
		// Language
		LanguageRegistry.addName(dechanterBlock, "Dechanter");
		
		// Recipes
		// GameRegistry.addShapelessRecipe(diamondStack, dirtStack);
		GameRegistry.addShapelessRecipe(dechanterStack, dirtStack);

	}
	
}
