package com.MCDungeons;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MCDungeons", version = "1.0")
public class MCDungeons
{
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		System.out.println("Hello world :)");
		//GameRegistry.registerWorldGenerator(new DungeonGenerator(),0);
		MinecraftForge.EVENT_BUS.register(new DungeonPortal());
    }
}

