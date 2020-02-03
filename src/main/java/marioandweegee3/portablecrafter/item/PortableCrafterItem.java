package marioandweegee3.portablecrafter.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PortableCrafterItem extends Item {

    public PortableCrafterItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote) {
            ITextComponent name = null;

            if(stack.hasDisplayName()) {
                name = stack.getDisplayName();
            } else {
                name = new TranslationTextComponent(this.getTranslationKey());
            }

            playerIn.openContainer(new PortableCrafterContainerProvider(name));
        }

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }

}