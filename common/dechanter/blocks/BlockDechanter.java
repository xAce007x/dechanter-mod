package dechanter.blocks;

import dechanter.LetsMod_Mod;
import dechanter.tileEntity.TileDechanter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDechanter extends BlockContainer {
	
	IconRegister icon;
	
	public BlockDechanter(int blockID, int textureID, Material material) {
		super(blockID, material);
		this.setHardness(0.5f).setStepSound(Block.soundStoneFootstep)
				//.setBlockName("Dechanter")
				.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean onBlockActivated(World world, int bx, int by, int bz,
			EntityPlayer playerEntity, int unknown, float px, float py, float pz) {

		if (playerEntity.isSneaking()) {
			return false;
		} else {
			
			playerEntity.openGui(LetsMod_Mod.instance, 0, world, bx, by, bz);
			return true;
		}
	}
	
	@Override
	public void registerIcons(IconRegister iconReg) {
		this.blockIcon = iconReg.registerIcon("blockDechanter");
	}
	
	/*
	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSide(int side) {
		switch (side) {
		case 0:
			return 2;
		case 1:
			return 1;
		default:
			return 0;
		}
	}
	
	public String getTextureFile() {
		return "/Dechant_Blocks.png";
	}
	*/
	@Override
	public TileEntity createNewTileEntity(World var1) {
		
		return new TileDechanter();
	}

}
