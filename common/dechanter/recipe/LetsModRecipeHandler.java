package dechanter.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dechanter.LetsMod_Mod;

public class LetsModRecipeHandler {
	
	final static Object[] dechanterRecipie = {
			"AYA", "XXX", "ACA", 'X',
			Block.bookShelf, 'A', Block.obsidian, 'Y', Item.netherStar, 'C', Block.enchantmentTable
			};
	final static Object[] dechantPaper = {
			"AAA", "AXA", "AAA", 'A', Item.paper, 'X', Item.enderPearl
	};
	
	public static void addRecipies() {
		GameRegistry.addRecipe(new ItemStack(LetsMod_Mod.dechanterBlock,1), dechanterRecipie);
		GameRegistry.addRecipe(new ItemStack(LetsMod_Mod.dechantPaperItem, 4), dechantPaper);
	}

}
