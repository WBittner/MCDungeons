package com.MCDungeons;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;

public class DungeonPortal {

	public DungeonPortal() {
	}
	
	@SubscribeEvent
	public void onBlockPlace(PlaceEvent event) {
	}
	
	@SubscribeEvent
	public void onItemDrop(ItemTossEvent event) {
		System.out.println(event.getEntityItem().getEntityItem().getItem());

		EntityPlayerMP p=(EntityPlayerMP)event.getPlayer();
        FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(p, 33,
                new DungeonTeleporter(p.getServer().worldServerForDimension(33)));
	}
}
