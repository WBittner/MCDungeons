package com.MCDungeons;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class DungeonGenerator implements IWorldGenerator
{
	private Random rand;
	
	public DungeonGenerator(WorldServer worldServer, ItemStack item)
	{
		super();
		rand = new Random(Item.getIdFromItem(item.getItem())*101+item.stackSize);
		ChunkCoordinates coords = worldServer.getSpawnPoint();
		System.out.println(coords);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		
		Block dirt = Block.getBlockFromName("dirt");
		for(int x = 0; x < 16; x++)
		{
			for(int z = 0; z < 16; z++)
			{
				for(int y = Math.max(0,world.getTopSolidOrLiquidBlock(chunkX + x, chunkZ + z)-10); y < world.getTopSolidOrLiquidBlock(chunkX + x, chunkZ + z); y++)
				{
					if(world.getBlock(chunkX*16 + x, y, chunkZ*16 + z).equals(dirt))
					{
						world.setBlock(chunkX*16 + x, y, chunkZ*16 + z, Block.getBlockById(0));
					}
				}
			}
		}
	}

}
