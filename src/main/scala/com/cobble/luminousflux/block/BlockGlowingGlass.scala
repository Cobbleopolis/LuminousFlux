package com.cobble.luminousflux.block

import com.cobble.luminousflux.reference.Reference.UnlocalizedNames
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.util.math.BlockPos
import net.minecraft.util.{BlockRenderLayer, EnumFacing}
import net.minecraft.world.IBlockAccess
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockGlowingGlass extends FluxBlock(Material.GLASS) {
    setUnlocalizedName(UnlocalizedNames.GLOWING_GLASS)
    setSoundType(SoundType.GLASS)
    setLightLevel(1F)
    setLightOpacity(0)

    @SideOnly(Side.CLIENT)
    override def getBlockLayer = BlockRenderLayer.TRANSLUCENT

    override def isFullCube(state: IBlockState): Boolean = false

    override def isOpaqueCube(state: IBlockState): Boolean = false

    @SideOnly(Side.CLIENT)
    override def shouldSideBeRendered(blockState: IBlockState,
                                      blockAccess: IBlockAccess,
                                      pos: BlockPos,
                                      side: EnumFacing): Boolean = {
        val iblockstate = blockAccess.getBlockState(pos.offset(side))
        val block = iblockstate.getBlock
        block != this
    }
}