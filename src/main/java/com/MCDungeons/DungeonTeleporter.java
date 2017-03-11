package com.MCDungeons;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DungeonTeleporter extends Teleporter {

    public DungeonTeleporter(WorldServer worldIn) {
        super(worldIn);
    }
}
