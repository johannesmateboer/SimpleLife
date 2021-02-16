package simplelife.common.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import simplelife.common.SimpleLife;

public class WorktableScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    //This constructor gets called on the client when the server wants it to open the screenHandler,
    //The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    //sync this empty inventory with the inventory on the server.
    public WorktableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    // This constructor gets called from the BlockEntity on the server without calling the other constructor first,
    // the server knows the inventory of the container
    // and can therefore directly provide it as an argument. This inventory will then be synced to the client.
    public WorktableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(SimpleLife.WORKTABLE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 9);
        this.inventory = inventory;

        // some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        //This will place the slot in the correct locations for a 3x3 Grid. The slots exist on both server and client!
        //This will not render the background of the slots however, this is the Screens job
        int gridLine;
        int gridColumn;
        //Our inventory
        for (gridLine = 0; gridLine < 3; ++gridLine) {
            for (gridColumn = 0; gridColumn < 3; ++gridColumn) {
                this.addSlot(new Slot(inventory, gridColumn + gridLine * 3, 62 + gridColumn * 18, 17 + gridLine * 18));
            }
        }
        //The player inventory
        for (gridLine = 0; gridLine < 3; ++gridLine) {
            for (gridColumn = 0; gridColumn < 9; ++gridColumn) {
                this.addSlot(new Slot(playerInventory, gridColumn + gridLine * 9 + 9, 8 + gridColumn * 18, 84 + gridLine * 18));
            }
        }
        //The player Hotbar
        for (gridLine = 0; gridLine < 9; ++gridLine) {
            this.addSlot(new Slot(playerInventory, gridLine, 8 + gridLine * 18, 142));
        }

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
