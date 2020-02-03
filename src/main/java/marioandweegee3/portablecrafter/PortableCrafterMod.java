package marioandweegee3.portablecrafter;

import marioandweegee3.portablecrafter.gui.PortableCrafterContainer;
import marioandweegee3.portablecrafter.item.PortableCrafterItem;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(PortableCrafterMod.modID)
public class PortableCrafterMod {
    public static final String modID = "portablecrafter";

    public static final ContainerType<PortableCrafterContainer> PORTABLE_CRAFTER = new ContainerType<>((syncId, playerInv) -> new PortableCrafterContainer(syncId, playerInv, IWorldPosCallable.of(playerInv.player.world, playerInv.player.getPosition())));

    public PortableCrafterMod() {

    }

    @Mod.EventBusSubscriber(bus = Bus.MOD)
    public static class Init {
        @SubscribeEvent
        public static void setupClient(FMLClientSetupEvent event) {
            ScreenManager.registerFactory(PORTABLE_CRAFTER, CraftingScreen::new);
        }

        @SubscribeEvent
        public static void setupCommon(FMLCommonSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> registry = event.getRegistry();

            registry.registerAll(
                new PortableCrafterItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)).setRegistryName(modID, "portable_crafter")
            );
        }

        @SubscribeEvent
        public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
            IForgeRegistry<ContainerType<?>> registry = event.getRegistry();

            registry.registerAll(
                PORTABLE_CRAFTER.setRegistryName(modID, "portable_crafter")
            );
        }
    }
}