package com.mrcrayfish.foamguns.core;

import com.mrcrayfish.foamguns.FoamGunsMod;
import com.mrcrayfish.foamguns.Reference;
import com.mrcrayfish.foamguns.util.ItemNames;
import com.mrcrayfish.guns.item.ItemAmmo;
import com.mrcrayfish.guns.item.ItemGun;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModItems
{
    private static final List<Item> ITEMS = new ArrayList<>();

    /* Create your items here */

    @GameRegistry.ObjectHolder(ItemNames.ASSAULTER)
    public static final Item ASSAULTER = null;

    @GameRegistry.ObjectHolder(ItemNames.FOAM_DART)
    public static final ItemAmmo FOAM_DART = null;

    private static void register()
    {
        /* Registering custom guns. Make sure you create a new gun json for every gun.
         * See "assets/foamguns/guns/assaulter.json" for an example. The json file is where you can
         * customize the properties for each of your weapons.
         *
         * For example of gun json, see MrCrayfish's Gun Mod repo
         * https://github.com/MrCrayfish/MrCrayfishGunMod/tree/master/src/main/resources/assets/cgm/guns
         *
         * */
        ITEMS.add(new ItemGun(new ResourceLocation(Reference.MOD_ID, "assaulter")).setCreativeTab(FoamGunsMod.TAB));

        /* Registering custom ammo. Make sure you change in your gun json to use your custom ammo if you implement one */
        ITEMS.add(new ItemAmmo(new ResourceLocation(Reference.MOD_ID, "foam_dart")).setCreativeTab(FoamGunsMod.TAB));
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event)
    {
        ModItems.register();
        ITEMS.forEach(item -> event.getRegistry().register(item));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void register(ModelRegistryEvent event)
    {
        ITEMS.forEach(ModItems::registerRender);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
