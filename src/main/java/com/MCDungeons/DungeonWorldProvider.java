package com.MCDungeons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeCache;
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
        return new DungeonChunkGenerator(worldObj, true, worldObj.getSeed(), new BlockPos(0,0,0));
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
}
