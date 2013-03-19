package lmm_mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileBlockDechanter extends TileEntity implements IInventory {
	
	private ItemStack[] inventory;
	
	// Constructor
	public TileBlockDechanter() {
		this.inventory = new ItemStack[27];
	}
	
	// Returns the Size of the inventory.
	@Override
	public int getSizeInventory() { return this.inventory.length; }

	
	// Returns the ItemStack in a given slot in the inventory
	@Override
	public ItemStack getStackInSlot(int slotIndex) { return this.inventory[slotIndex]; }
	
	
	//  Reduces a stack in a slot of the inventory
	@Override
	public ItemStack decrStackSize(int slotIndex, int amt) {
		ItemStack stack = getStackInSlot(slotIndex);
		
		if(stack != null) {
			if(stack.stackSize <= amt) {
				setInventorySlotContents(slotIndex, null);
			} else {
				stack = stack.splitStack(amt);
				if(stack.stackSize == 0) {
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return stack;
	}

	
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		ItemStack stack = getStackInSlot(slotIndex);
		
		if(stack != null) {
			setInventorySlotContents(slotIndex, null);
		}
		
		return stack;
	}

	// Sets the ItemStack for a slot in the inventory.
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.inventory[slot] = stack;
		
		if(stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	// Duh gets the name of the inventory
	@Override
	public String getInvName() { return "TileBlockDechanter"; }

	// Stack limits for slots in inventory
	@Override
	public int getInventoryStackLimit() { return 64; }
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)
				== this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	// Method call when inventory is opened.
	@Override
	public void openChest() { }

	// Method call when inventory is closed
	@Override
	public void closeChest() { }
	
	
	// Reading NBT data on objects passed in.
	@Override
	public void readFromNBT(NBTTagCompound NBTTag) {
		super.readFromNBT(NBTTag);
		NBTTagList tagList = NBTTag.getTagList("Inventory");
		
		for(int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if(slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	// Writing to NBT data
	@Override
	public void writeToNBT(NBTTagCompound NBTTag) {
		super.writeToNBT(NBTTag);
		NBTTagList itemList = new NBTTagList();
		
		for(int i = 0; i < inventory.length; i++) {
			ItemStack stack = inventory[i];
			if(stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
	}

}
