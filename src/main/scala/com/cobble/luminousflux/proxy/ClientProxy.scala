package com.cobble.luminousflux.proxy

import com.cobble.luminousflux.reference.FluxBlocks

class ClientProxy extends CommonProxy {

    override def getClientProxy: ClientProxy = this

    override def registerKeybindings(): Unit = {}

    override def initRenderingAndTextures(): Unit = {}

    override def spawnParticle(particleName: String, xCoord: Double, yCoord: Double, zCoord: Double, xVelocity: Double, yVelocity: Double, zVelocity: Double): Unit = {}

    override def playSound(soundName: String, xCoord: Float, yCoord: Float, zCoord: Float, volume: Float, pitch: Float): Unit = {}

    override def registerRenderers(): Unit = {
        FluxBlocks.registerItemRenderers()
    }
}
