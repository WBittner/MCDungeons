package com.MCDungeons;

import net.minecraft.world.biome.Biome;

/**
 * Created by William on 2/5/2017.
 */
public class BiomeDungeon extends Biome {

    public BiomeDungeon(BiomeProperties properties) {
        super(properties);

        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    }

}
