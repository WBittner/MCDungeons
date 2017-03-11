package com.MCDungeons;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
public class DungeonChunkGenerator implements IChunkGenerator
{
    /** Blocks used **/
    protected static final IBlockState END_STONE = Blocks.END_STONE.getDefaultState();
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();

    /** Reference to the World object. */
    private final World worldObj;

    // temporary variables used during event handling
    private int chunkX = 0;
    private int chunkZ = 0;

    // Tweaks for dev mode (like no ceilings)
    boolean devMode;

    public DungeonChunkGenerator(World p_i47241_1_, boolean p_i47241_2_, long p_i47241_3_, BlockPos p_i47241_5_)
    {
        this.devMode = false;
        this.worldObj = p_i47241_1_;
    }

    public void fillInWallOutline(ChunkPrimer primer)
    {
        for(int x = 0; x < 16; x++) {
            for(int z = 0; z < 16; z++) {
                for(int y = 50; y < 58; y++) {
                    if(y == 50) {
                        //floor
                        primer.setBlockState(x, y, z, END_STONE);
                    }
                    else if(y == 57) {
                        //ceiling
                        if(this.devMode == true) {
                            primer.setBlockState(x, y, z, AIR);
                        }
                        else {
                            primer.setBlockState(x, y, z, END_STONE);
                        }
                    }
                    else if(x == 0 || x == 15 || z == 0 || z == 15) {
                        if((x == 8 || z == 8) && (y == 51 || y == 52)) {
                            //doorway goes here
                            primer.setBlockState(x, y, z, AIR);
                        } else {
                            //walls
                            primer.setBlockState(x, y, z, END_STONE);
                        }
                    }
                    else {
                        //else air
                        primer.setBlockState(x, y, z, AIR);
                    }
                }
            }
        }
    }

    public void buildSurfaces(ChunkPrimer primer) {
    }

    public Chunk provideChunk(int x, int z)
    {
        this.chunkX = x; this.chunkZ = z;
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.fillInWallOutline(chunkprimer);
        this.buildSurfaces(chunkprimer);

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(MCDungeons.dungeonBiome);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    public void populate(int x, int z)
    {
    }

    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
        return false;
    }

    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        return null;
    }

    @Nullable
    public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_)
    {
        return null;
    }

    public void recreateStructures(Chunk chunkIn, int x, int z)
    {
    }
}