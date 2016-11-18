package com.cobble.luminousflux.block

import java.util.Random

import com.cobble.luminousflux.reference.Reference.UnlocalizedNames
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyBool
import net.minecraft.block.state.{BlockStateContainer, IBlockState}
import net.minecraft.block.{Block, SoundType}
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.{AxisAlignedBB, BlockPos}
import net.minecraft.world.{IBlockAccess, World}
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockLamp(inverted: Boolean = false) extends FluxBlock(Material.GLASS) {

    if (inverted)
        setUnlocalizedName(UnlocalizedNames.INVERTED_LUMINOUS_LAMP)
    else
        setUnlocalizedName(UnlocalizedNames.LUMINOUS_LAMP)
    setSoundType(SoundType.GLASS)
    setLightLevel(0F)
    setLightOpacity(0)

    setDefaultState(blockState.getBaseState.withProperty(BlockLamp.isPowered, inverted.asInstanceOf[java.lang.Boolean]))

    @SideOnly(Side.CLIENT)
    override def getBlockLayer = BlockRenderLayer.CUTOUT_MIPPED

    override def isFullCube(state: IBlockState): Boolean = false

    override def isOpaqueCube(state: IBlockState): Boolean = false

    override def onBlockAdded(world: World, pos: BlockPos, state: IBlockState): Unit = {
        if (!world.isRemote)
            world.setBlockState(pos, state.withProperty(BlockLamp.isPowered, world.isBlockPowered(pos).asInstanceOf[java.lang.Boolean]), 2)
    }

    override def neighborChanged(state: IBlockState, world: World, pos: BlockPos, block: Block, otherBlockPos: BlockPos): Unit = {
        if (!world.isRemote)
            if (!world.isBlockPowered(pos))
                world.scheduleUpdate(pos, this, 4)
            else if (world.isBlockPowered(pos))
                world.setBlockState(pos, state.withProperty(BlockLamp.isPowered, true.asInstanceOf[java.lang.Boolean]), 2)
    }

    override def updateTick(world: World, pos: BlockPos, state: IBlockState, rand: Random): Unit = {
        if (!world.isRemote)
            if (!world.isBlockPowered(pos)) {
                world.setBlockState(pos, state.withProperty(BlockLamp.isPowered, false.asInstanceOf[java.lang.Boolean]), 2)
            }
    }

    override def getMetaFromState(state: IBlockState): Int = {
        if (state.getValue(BlockLamp.isPowered).asInstanceOf[Boolean]) 1 else 0
    }

    override def getStateFromMeta(meta: Int): IBlockState = {
        getDefaultState.withProperty(BlockLamp.isPowered, (meta != 0).asInstanceOf[java.lang.Boolean])
    }

    override protected def createBlockState(): BlockStateContainer = {
        new BlockStateContainer(this, BlockLamp.isPowered)
    }

    override def getLightValue(state: IBlockState, world: IBlockAccess, pos: BlockPos): Int = {
        (inverted, state.getValue[java.lang.Boolean](BlockLamp.isPowered).booleanValue()) match {
            case (true, true) => 0
            case (true, false) => 15
            case (false, true) => 15
            case (false, false) => 0
            case _ => 15
        }
    }

    override def getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB =
        new AxisAlignedBB(0.125d, 0.0d, 0.125d, 0.875d, 0.875d, 0.875d)

}

object BlockLamp {
    val isPowered: PropertyBool = PropertyBool.create("on")
}