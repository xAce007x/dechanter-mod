package lmm_mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDechanter extends Block {

	public BlockDechanter(int blockID, int textureID, Material material) {
		super(blockID, textureID, material);
		this.setHardness(0.5f).setStepSound(Block.soundStoneFootstep).
		setBlockName("Dechanter").setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSide(int side) {
		switch (side) {
			case 0 : return 2;
			case 1 : return 1;
			default : return 0;
		}
	}
	
	public String getTextureFile() {
		return "/Dechant_Blocks.png";
	}

}
