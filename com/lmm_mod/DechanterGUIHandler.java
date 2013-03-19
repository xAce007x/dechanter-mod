package lmm_mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class DechanterGUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		TileEntity theTile = world.getBlockTileEntity(x,y,z);
		
		if(theTile instanceof TileBlockDechanter) {
			return new DechanterContainer((TileBlockDechanter)theTile, player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		TileEntity theTile = world.getBlockTileEntity(x, y, z);
		
		if(theTile instanceof TileBlockDechanter) {
			return new DechanterGUI(player.inventory, (TileBlockDechanter)theTile);
		}
		return null;
	}

}
