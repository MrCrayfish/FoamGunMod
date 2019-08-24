package com.mrcrayfish.foamguns.core;

import com.google.common.collect.Lists;
import com.mrcrayfish.foamguns.Reference;
import com.mrcrayfish.foamguns.util.SoundNames;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModSounds
{
    private static final List<SoundEvent> REGISTRY = Lists.newArrayList();

    @GameRegistry.ObjectHolder(SoundNames.ITEM_ASSAULTER_FIRE)
    public static final SoundEvent ITEM_ASSAULTER_FIRE = null;

    @GameRegistry.ObjectHolder(SoundNames.ITEM_ASSAULTER_RELOAD)
    public static final SoundEvent ITEM_ASSAULTER_RELOAD = null;

    private static void register()
    {
        registerSound(SoundNames.ITEM_ASSAULTER_FIRE);
        registerSound(SoundNames.ITEM_ASSAULTER_RELOAD);
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation resource = new ResourceLocation(name);
        SoundEvent sound = new SoundEvent(resource).setRegistryName(resource.toString());
        REGISTRY.add(sound);
        return sound;
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
    {
        ModSounds.register();
        REGISTRY.forEach(sound -> event.getRegistry().register(sound));
    }
}
