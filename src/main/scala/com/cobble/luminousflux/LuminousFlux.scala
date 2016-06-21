package com.cobble.luminousflux

import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = "@MODID@", name = "@MODNAME@", version = "@VERSION@", modLanguage = "scala") //DO NOT CHANGE THE MODID OR THE MODNAME W/O UPDATING THE REFERENCE FILE
object LuminousFlux {

	@EventHandler
	def init(event: FMLInitializationEvent): Unit = {
		println("DIRT BLOCK >> " + Blocks.DIRT.getUnlocalizedName)
	}
}