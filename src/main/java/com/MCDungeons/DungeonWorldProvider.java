package com.MCDungeons;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by William on 1/4/2017.
 */
public class DungeonWorldProvider  extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return DimensionType.THE_END;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new DungeonChunkGenerator(worldObj);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
}
