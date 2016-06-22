package com.cobble.luminousflux.proxy

class ServerProxy extends CommonProxy {

    override def getClientProxy: ClientProxy = null

    override def initRenderingAndTextures(): Unit = {}

    override def registerKeybindings(): Unit = {}

    override def playSound(soundName: String,
                           xCoord: Float,
                           yCoord: Float,
                           zCoord: Float,
                           volume: Float,
                           pitch: Float): Unit = {}

    override def spawnParticle(particleName: String,
                               xCoord: Double,
                               yCoord: Double,
                               zCoord: Double,
                               xVelocity: Double,
                               yVelocity: Double,
                               zVelocity: Double): Unit = {}

    override def registerRenderers(): Unit = {}
}
