package lmm_mod;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class BlockDechanter extends Block {

	public BlockDechanter(int blockID, int textureID, Material material) {
		super(blockID, textureID, material);
		this.setHardness(0.5f).setStepSound(Block.soundStoneFootstep).
		setBlockName("Dechanter").setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean onBlockActivated(World world, int bx, int by, int bz,
			EntityPlayer playerEntity, int unknown, float px, float py, float pz) {
		
		Random random = new Random();
		int randInt1 = random.nextInt();
		int randInt2 = random.nextInt();
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(randInt1);
			outputStream.writeInt(randInt2);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "LetsMod_Mod";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			EntityPlayerMP player = (EntityPlayerMP) playerEntity;
		} else if (side == Side.CLIENT) {
			EntityClientPlayerMP player = (EntityClientPlayerMP) playerEntity;
			player.sendQueue.addToSendQueue(packet);
		}
		
		return false;
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
