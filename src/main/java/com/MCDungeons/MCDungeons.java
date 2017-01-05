package com.MCDungeons;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "mcdungeons", version = "0.1")
public class MCDungeons {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        DimensionType dt = DimensionType.register("dungeondim","void", 33, DungeonWorldProvider.class, false);
        DimensionManager.registerDimension(33, dt);
    }

	@EventHandler
    public void init(FMLInitializationEvent event) {
		System.out.println("Hello world :)");
        MinecraftForge.EVENT_BUS.register(new DungeonPortal());
    }
}

