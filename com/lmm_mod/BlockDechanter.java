package lmm_mod;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDechanter extends Block {

	protected BlockDechanter(int blockID, int textureID, Material material) {
		super(blockID, textureID, material);
		this.setHardness(0.5f).setStepSound(Block.soundStoneFootstep).
		setBlockName("Dechanter").setCreativeTab(CreativeTabs.tabBlock);
	}
}
