package com.MCDungeons;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "MCDungeons", version = "1.0")
public class MCDungeons
{
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		System.out.println("Hello world :)");
    }
}

