package com.mrcrayfish.foamguns.entity;

import com.mrcrayfish.foamguns.core.ModItems;
import com.mrcrayfish.guns.entity.EntityProjectile;
import com.mrcrayfish.guns.object.Gun;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish
 */
public class EntityFoamDart extends EntityProjectile
{
    public EntityFoamDart(World worldIn)
    {
        super(worldIn);
    }

    public EntityFoamDart(World worldIn, EntityLivingBase shooter, Gun.Projectile projectile)
    {
        super(worldIn, shooter, projectile);
    }

    @Override
    protected void onHitEntity(Entity entity, double x, double y, double z)
    {
        super.onHitEntity(entity, x, y, z);
        this.onHit(x, y, z);
    }

    @Override
    protected void onHitBlock(IBlockState state, BlockPos pos, double x, double y, double z)
    {
        this.onHit(x, y, z);
    }

    private void onHit(double x, double y, double z)
    {
        world.spawnEntity(new EntityItem(world, x, y, z, new ItemStack(ModItems.FOAM_DART)));
    }
}
