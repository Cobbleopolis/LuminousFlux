package com.cobble.luminousflux

import com.cobble.luminousflux.reference.{FluxBlocks, Reference}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class LuminousFluxTab extends CreativeTabs(Reference.MODID) {
    
    @SideOnly(Side.CLIENT)
    override def getTabIconItem: Item = Item.getItemFromBlock(FluxBlocks.invertedLamp)
    
}
