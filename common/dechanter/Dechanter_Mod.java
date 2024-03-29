package dechanter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dechanter.blocks.BlockDechanter;
import dechanter.gui.DechanterGUIHandler;
import dechanter.items.ItemDechantPaper;
import dechanter.recipe.LetsModRecipeHandler;
import dechanter.tileEntity.TileDechanter;

@Mod(modid = "Dechanter_Mod", name = "Dechanter", version = "In-Dev 1.0")
@NetworkMod(channels = { "Dechanter_Mod" },
		clientSideRequired = true,
		serverSideRequired = false,
		packetHandler = PacketHandler.class)
public class Dechanter_Mod {

	@Instance("Dechanter_Mod")
	public static Dechanter_Mod instance = new Dechanter_Mod();

	@SidedProxy(clientSide = "dechanter.ClientProxy",
			serverSide = "dechanter.CommonProxy")
	public static CommonProxy proxy;

	// GUI Handler
	private DechanterGUIHandler guiHandler = new DechanterGUIHandler();

	// Block and Item IDs
	protected static int dechanterBlockID;
	protected static int dechantPaperID;

	// Block decelerations
	public static Block dechanterBlock;

	// Item Decelerations
	public static Item dechantPaperItem;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();

		dechanterBlockID = config.getBlock("DechanterBlock", 1000,
				"The Dechanter Block").getInt();
		dechantPaperID = config.getItem("DechantingPaper", 5000,
				"Dechanting Paper").getInt();

		config.save();
	}

	@Init
	public void load(FMLInitializationEvent event) {

		// Block field setup
		dechanterBlock = new BlockDechanter(dechanterBlockID, 0, Material.rock);

		// Item field setup
		dechantPaperItem = new ItemDechantPaper(dechantPaperID);

		// Game Registry
		GameRegistry.registerBlock(dechanterBlock, "dechanterBlock");
		GameRegistry.registerItem(dechantPaperItem, "dechantPaper");
		GameRegistry.registerTileEntity(TileDechanter.class,
				"Dechanter Block Tile Entity");

		// Recipe handling
		LetsModRecipeHandler.addRecipies();

		// Language Registry
		LanguageRegistry.addName(dechanterBlock, "Dechanter");
		LanguageRegistry.addName(dechantPaperItem, "Dechanting Paper");

		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		// Dungeon Hooks
		// -- Removed for now -- DechanterDungeonChestHandler.addDungeonLoot();

		// Register proxy stuff.
		proxy.registerRenderThings();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}

}
