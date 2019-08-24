package com.mrcrayfish.foamguns;

import com.mrcrayfish.foamguns.core.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

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

    /*@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        AmmoRegistry.getInstance().registerProjectileFactory(ModItems.FOAM_DART, (world, entityLivingBase, gun) -> new EntityProjectile(world, entityLivingBase, gun.projectile));
    }*/
}
