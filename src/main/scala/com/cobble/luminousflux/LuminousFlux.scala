package com.cobble.luminousflux

import com.cobble.luminousflux.proxy.{CommonProxy, IProxy}
import com.cobble.luminousflux.reference.FluxBlocks
import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

@Mod(modid = "luminousflux", name = "Luminous Flux", version = "@VERSION@", modLanguage = "scala") //DO NOT CHANGE THE MODID OR THE MODNAME W/O UPDATING THE REFERENCE FILE
object LuminousFlux {

    @Mod.Instance(value = "luminousflux")
    var luminousFlux = null

    @SidedProxy(clientSide="com.cobble.luminousflux.proxy.ClientProxy", serverSide="com.cobble.luminousflux.proxy.ServerProxy")
    var proxy: IProxy = null

    @EventHandler
    def preInit(event: FMLPreInitializationEvent): Unit = {
        FluxBlocks.registerBlocks()
    }

	@EventHandler
	def init(event: FMLInitializationEvent): Unit = {
		println("DIRT BLOCK >> " + Blocks.DIRT.getUnlocalizedName)
        proxy.registerRenderers()
	}

    @EventHandler
    def postInit(e: FMLPostInitializationEvent): Unit = {}
}