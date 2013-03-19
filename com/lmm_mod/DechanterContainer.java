package lmm_mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DechanterContainer extends Container {
	
	protected TileBlockDechanter theTile;

	public DechanterContainer(TileBlockDechanter theTile, InventoryPlayer inventory) {
		
		// Binds a tile entity to this object.
		this.theTile = theTile;
		
		// Counting var;
		int o = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++) {
				
				// Adds slots to the container
				addSlotToContainer(new Slot(theTile, o, 9+j*18, 9+i*18));
				
				// Binds the player inventory to the container.
				bindPlayerInventory(inventory);
				o++;
			}
		}
		
		
	}

	private void bindPlayerInventory(InventoryPlayer inventory) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 9 + j * 18, 85 + i * 16));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventory, i, 6 + i * 16, 142));
		}
		
	}
	
	
	@Override
	public void putStackInSlot(int slotIndex, ItemStack stack) {
		Slot slot = (Slot) inventorySlots.get(slotIndex);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			if(slotIndex == 0) {
				if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true)) { stack.stackSize=0; }
				else if (!mergeItemStack(stackInSlot, 0, 1, true)) { stack.stackSize=0; }
				else { slot.onSlotChanged(); }
			}
		}
	}
	
	@Override
	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer player) {
		ItemStack stack = null;
		Slot slot = (Slot) inventorySlots.get(par1);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			if(par1 == 0) {
				if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true)) { return null; }
				else if (!mergeItemStack(stackInSlot, 0, 1, true)) { return null; }
				else { slot.onSlotChanged(); }
			}
		}
		
		return stack;
	}
	
	// Can the player interact w/ this item.
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return theTile.isUseableByPlayer(player);
	}

}
