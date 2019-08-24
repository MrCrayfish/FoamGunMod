package com.mrcrayfish.foamguns.proxy;

import com.mrcrayfish.foamguns.client.render.entity.RenderFoamDart;
import com.mrcrayfish.foamguns.core.ModItems;
import com.mrcrayfish.foamguns.entity.EntityFoamDart;
import com.mrcrayfish.guns.client.gui.DisplayProperty;
import com.mrcrayfish.guns.client.gui.GuiWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Author: MrCrayfish
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityFoamDart.class, RenderFoamDart::new);
    }

    @Override
    public void init()
    {
        /* Adds a display property for items so they render nicely in the workbench GUI */
        GuiWorkbench.addDisplayProperty(new ItemStack(ModItems.FOAM_DART), new DisplayProperty(0.0, 0.15, 0.0, 5.0));
        GuiWorkbench.addDisplayProperty(new ItemStack(ModItems.ASSAULTER), new DisplayProperty(0.0, 0.55, -0.15, 0.0, 0.0, 0.0, 3.0));
    }
}
