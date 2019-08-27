package com.mrcrayfish.foamguns;

import com.mrcrayfish.foamguns.core.ModItems;
import com.mrcrayfish.foamguns.entity.EntityFoamDart;
import com.mrcrayfish.foamguns.proxy.CommonProxy;
import com.mrcrayfish.guns.client.gui.DisplayProperty;
import com.mrcrayfish.guns.client.gui.GuiWorkbench;
import com.mrcrayfish.guns.common.WorkbenchRegistry;
import com.mrcrayfish.guns.item.AmmoRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
 * This is all you need in your mod class to create an addon.
 */

/**
 * Author: MrCrayfish
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = Reference.DEPENDENCIES)
public class FoamGunsMod
{
    public static final CreativeTabs TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.ASSAULTER);
        }
    };

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "foam_dart"), EntityFoamDart.class, Reference.MOD_ID + ".foam_dart", 0, this, 64, 80, true);
        proxy.preInit();
    }

    /*
     * Uncomment this below if you want make your custom ammo to shoot a custom projectile. A projectile is
     * an entity, so you will need to register it as normally would for an entity.
     *
     * You can copy the registration from MrCrayfish's Gun Mod
     * https://github.com/MrCrayfish/MrCrayfishGunMod/blob/master/src/main/java/com/mrcrayfish/guns/init/ModEntities.java#L15
     *
     * The missile entity is an example of a custom projectile. You can see the example here.
     * https://github.com/MrCrayfish/MrCrayfishGunMod/blob/master/src/main/java/com/mrcrayfish/guns/entity/EntityMissile.java
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        /* Registering projectile factories must be done in the init phase or later. If you do it in preInit, the item will be null. */
        AmmoRegistry.getInstance().registerProjectileFactory(ModItems.FOAM_DART, EntityFoamDart::new);

        /* Register new crafting recipes to the workbench */
        WorkbenchRegistry.registerRecipe(new ItemStack(ModItems.FOAM_DART, 64),
                new ItemStack(Blocks.SPONGE));
        WorkbenchRegistry.registerRecipe(new ItemStack(ModItems.ASSAULTER),
                new ItemStack(Items.IRON_INGOT, 8),
                new ItemStack(Blocks.CONCRETE, 1, EnumDyeColor.YELLOW.getMetadata()),
                new ItemStack(Blocks.CONCRETE, 1, EnumDyeColor.LIME.getMetadata()));

        proxy.init();
    }
}
