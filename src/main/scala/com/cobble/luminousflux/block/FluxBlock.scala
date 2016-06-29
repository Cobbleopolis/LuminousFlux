package com.cobble.luminousflux.block

import com.cobble.luminousflux.reference.FluxBlocks
import net.minecraft.block.BlockBreakable
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState

abstract class FluxBlock(material: Material, ignoreSimilarityIn: Boolean = false, addToBlockList: Boolean = true) extends BlockBreakable(material, ignoreSimilarityIn) {
    if(addToBlockList)
        FluxBlocks.blockArray += this

    override def isOpaqueCube(state: IBlockState): Boolean = true
}
