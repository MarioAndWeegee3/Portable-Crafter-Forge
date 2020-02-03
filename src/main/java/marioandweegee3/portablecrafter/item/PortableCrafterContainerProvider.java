package marioandweegee3.portablecrafter.item;

import marioandweegee3.portablecrafter.PortableCrafterMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

public class PortableCrafterContainerProvider implements INamedContainerProvider {
    private ITextComponent name;

    public PortableCrafterContainerProvider(ITextComponent name) {
        this.name = name;
    }

    @Override
    public Container createMenu(int syncId, PlayerInventory playerInv, PlayerEntity player) {
        return PortableCrafterMod.PORTABLE_CRAFTER.create(syncId, playerInv);
    }

    @Override
    public ITextComponent getDisplayName() {
        return name;
    }

}