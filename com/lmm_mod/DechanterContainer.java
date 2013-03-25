package lmm_mod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DechanterContainer extends Container {

	protected TileBlockDechanter theTile;
	private int numRows;

	public DechanterContainer(TileBlockDechanter theTile,
			InventoryPlayer inventory) {

		// Binds a tile entity to this object.
		this.theTile = theTile;
		this.numRows = inventory.getSizeInventory() / 9;

		// Counting var;
		int o = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {

				// Adds slots to the container
				addSlotToContainer(new Slot(theTile, o, -4 + j * 18,
						14 + i * 18));
				o++;
			}
		}

		// Binds the player inventory to the container.
		bindPlayerInventory(inventory);
	}

	private void bindPlayerInventory(InventoryPlayer inventory) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventory, j + i * 9 + 9,
						9 + j * 18, 82 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventory, i, 6 + i * 18, 142));
		}

	}
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotIndex)
    {
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack stackPlaceHolder = slot.getStack();
            stack = stackPlaceHolder.copy();

            if (slotIndex < this.numRows * 9)
            {
                if (!this.mergeItemStack(stackPlaceHolder, this.numRows * 9,
                		this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(stackPlaceHolder, 0, this.numRows * 9, false))
            {
                return null;
            }

            if (stackPlaceHolder.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return stack;
    }
	
	/*--------------------------Inserted Code from ContainerChest----------------------*/
	
	@Override
	protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4)
    {
        boolean var5 = false;
        int var6 = par2;

        if (par4)
        {
            var6 = par3 - 1;
        }

        Slot var7;
        ItemStack var8;

        if (par1ItemStack.isStackable())
        {
            while (par1ItemStack.stackSize > 0 && (!par4 && var6 < par3 || par4 && var6 >= par2))
            {
                var7 = (Slot)this.inventorySlots.get(var6);
                var8 = var7.getStack();

                if (var8 != null && var8.itemID == par1ItemStack.itemID && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == var8.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, var8))
                {
                    int var9 = var8.stackSize + par1ItemStack.stackSize;

                    if (var9 <= par1ItemStack.getMaxStackSize())
                    {
                        par1ItemStack.stackSize = 0;
                        var8.stackSize = var9;
                        var7.onSlotChanged();
                        var5 = true;
                    }
                    else if (var8.stackSize < par1ItemStack.getMaxStackSize())
                    {
                        par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - var8.stackSize;
                        var8.stackSize = par1ItemStack.getMaxStackSize();
                        var7.onSlotChanged();
                        var5 = true;
                    }
                }

                if (par4)
                {
                    --var6;
                }
                else
                {
                    ++var6;
                }
            }
        }

        if (par1ItemStack.stackSize > 0)
        {
            if (par4)
            {
                var6 = par3 - 1;
            }
            else
            {
                var6 = par2;
            }

            while (!par4 && var6 < par3 || par4 && var6 >= par2)
            {
                var7 = (Slot)this.inventorySlots.get(var6);
                var8 = var7.getStack();

                if (var8 == null)
                {
                    var7.putStack(par1ItemStack.copy());
                    var7.onSlotChanged();
                    par1ItemStack.stackSize = 0;
                    var5 = true;
                    break;
                }

                if (par4)
                {
                    --var6;
                }
                else
                {
                    ++var6;
                }
            }
        }

        return var5;
    }
	
	/*--------------------------------End Inserted Code---------------------------*/
	
	// Can the player interact w/ this item.
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return theTile.isUseableByPlayer(player);
	}

}
