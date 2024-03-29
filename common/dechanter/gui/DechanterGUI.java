package dechanter.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import dechanter.inventory.DechanterContainer;
import dechanter.tileEntity.TileDechanter;

public class DechanterGUI extends GuiContainer {

	public DechanterGUI(InventoryPlayer playerInv, TileDechanter tileEntity) {
		super(new DechanterContainer(tileEntity, playerInv));
	}

	// Draws the background (what you can normally see) for the container's GUI
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		String picture = "/Dechant_Blocks.png";
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(picture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

	}

	// Foreground layer of the container's inventory GUI
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {

		fontRenderer.drawString("Dechanter", 6, 6, 0xFFFFFF);
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 6,
				ySize - 96, 0xFFFFFF);
	}

}
