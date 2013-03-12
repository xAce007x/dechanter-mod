package lmm_mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDechantPaper extends Item {

	public ItemDechantPaper(int itemID) {
		super(itemID);
		this.setItemName("dechantPaperItem").setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getTextureFile() {
		return "/Items.png";
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRareity (ItemStack item) {
		return EnumRarity.uncommon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack item) {
		return true;
	}

}
