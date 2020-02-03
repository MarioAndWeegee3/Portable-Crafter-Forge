package marioandweegee3.portablecrafter.item;

import marioandweegee3.portablecrafter.PortableCrafterMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PortableCrafterItem extends Item implements INamedContainerProvider {

    public PortableCrafterItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote) {
            playerIn.openContainer(this);
        }

        return ActionResult.newResult(ActionResultType.SUCCESS, stack);
    }

    @Override
    public Container createMenu(int syncId, PlayerInventory playerInv, PlayerEntity player) {
        return PortableCrafterMod.PORTABLE_CRAFTER.create(syncId, playerInv);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getTranslationKey());
    }

}