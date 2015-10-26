package com.MCDungeons;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;

public class DungeonPortal
{
	public DungeonPortal()
	{
	}
	
	@SubscribeEvent
	public void onBlockPlace(PlaceEvent event)
	{
		if(event.block.equals(Block.getBlockFromName("tripwire")))
		{
			
		}
	}
	
	@SubscribeEvent
	public void onItemDrop(ItemTossEvent event)
	{
		System.out.println(event.entityItem.getEntityItem().getItem());
		event.player.worldObj.removeEntity(event.entityItem);
		int dim = DimensionManager.getNextFreeDimId();
		DimensionManager.registerDimension(dim, 0);
		
		WorldProvider wp = WorldProvider.getProviderForDimension(dim);
		wp.terrainType = WorldType.FLAT;
		wp.isHellWorld = true;
		wp.setDimension(dim);
		
		EntityPlayerMP p=(EntityPlayerMP)event.player;
		p.mcServer.getConfigurationManager().transferPlayerToDimension(p, dim, new DungeonTeleporter(p.mcServer.worldServerForDimension(dim)));
	}
}
