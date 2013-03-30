package dechanter.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDechantPaper extends Item {

	public ItemDechantPaper(int itemID) {
		super(itemID);
		this.setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(8).
		setUnlocalizedName("dechantPaper");
	}
	

	public ItemStack onItemRightClick(ItemStack ItemStack, World world, Entity playerEntity) {

		return ItemStack;
		
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
