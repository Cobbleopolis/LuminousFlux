package com.cobble.luminousflux.block

import java.util.Random

import com.cobble.luminousflux.reference.FluxBlocks
import net.minecraft.block.{Block, SoundType}
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.{IBlockAccess, World}
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockLamp(isOn: Boolean) extends FluxBlock(Material.GLASS) {
	if (isOn)
		setUnlocalizedName("fluxLamp_On")
	else
		setUnlocalizedName("fluxLamp_Off")
	setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
	setSoundType(SoundType.GLASS)
	setLightLevel(if (isOn) 1F else 0F)
	setLightOpacity(0)

	@SideOnly(Side.CLIENT)
	override def getBlockLayer = BlockRenderLayer.TRANSLUCENT

	override def isFullCube(state: IBlockState): Boolean = false

	override def isOpaqueCube(state: IBlockState): Boolean = false

	override def onBlockAdded(world: World, pos: BlockPos, state: IBlockState): Unit = {
		if (!world.isRemote)
			if (isOn && !world.isBlockPowered(pos))
				world.setBlockState(pos, FluxBlocks.lampOff.getDefaultState, 2)
			else if (!isOn && world.isBlockPowered(pos))
				world.setBlockState(pos, FluxBlocks.lampOn.getDefaultState, 2)
	}

	override def onNeighborChange(blockAccess: IBlockAccess, pos: BlockPos, neighborPos: BlockPos): Unit = {

	}

	override def updateTick(world: World, pos: BlockPos, state: IBlockState, rand: Random): Unit = {

	}
}