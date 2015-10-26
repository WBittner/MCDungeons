package com.MCDungeons;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DungeonTeleporter extends Teleporter
{
	public DungeonTeleporter(WorldServer p_i1963_1_)
	{
		super(p_i1963_1_);
	}

	// Override Default BS
    @Override
    public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
    {
        return false;
    }

    @Override
    public void removeStalePortalLocations(long par1)
    {
    }

    @Override
    public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
    {
    }
}
