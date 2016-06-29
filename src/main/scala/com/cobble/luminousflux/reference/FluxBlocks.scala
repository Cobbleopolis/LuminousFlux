package com.cobble.luminousflux.reference

import com.cobble.luminousflux.block.{BlockGlowingGlass, BlockLamp, FluxBlock}
import com.cobble.luminousflux.config.Constants
import net.minecraft.block.Block
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.fml.common.registry.GameRegistry

import scala.collection.mutable.ArrayBuffer

object FluxBlocks {
    val blockArray: ArrayBuffer[FluxBlock] = ArrayBuffer[FluxBlock]()

    val glowingGlass: BlockGlowingGlass = new BlockGlowingGlass

	val lamp: BlockLamp = new BlockLamp()

    def registerBlocks(): Unit = {
        println("Begin registering blocks...")
        blockArray.foreach(registerBlock)
        println("Finished registering blocks...")
    }

    def registerBlock(block: FluxBlock): Unit = {
        GameRegistry.register(block.setRegistryName(block.getUnlocalizedName))
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getUnlocalizedName))
    }

    def registerItemRenderers(): Unit = {
        println("Registering item renderers...")
        registerBlockItemRender(glowingGlass)
        registerBlockItemRender(lamp)
        println("Finished registering item renderers...")
    }

    def registerBlockItemRender(block: FluxBlock, meta: Int = 0): Unit = {
        Minecraft.getMinecraft.getRenderItem.getItemModelMesher.register(Item.getItemFromBlock(block.asInstanceOf[Block]), meta, new ModelResourceLocation(Constants.RESOURCE_PREFIX + block.getUnlocalizedName, "inventory"))
    }
    
}
