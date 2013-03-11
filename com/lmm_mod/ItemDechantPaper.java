package lmm_mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemDechantPaper extends Item {

	public ItemDechantPaper(int ItemID, int textureID) {
		super(ItemID);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getTextureFile() {
		return "item.png";
	}

}
