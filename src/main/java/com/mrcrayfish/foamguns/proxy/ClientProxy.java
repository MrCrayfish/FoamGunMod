package com.mrcrayfish.foamguns.proxy;

import com.mrcrayfish.foamguns.client.render.entity.RenderFoamDart;
import com.mrcrayfish.foamguns.entity.EntityFoamDart;
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
}
