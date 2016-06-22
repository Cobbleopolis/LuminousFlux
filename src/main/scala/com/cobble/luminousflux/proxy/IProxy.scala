package com.cobble.luminousflux.proxy


trait IProxy {

    def getClientProxy: ClientProxy

    def initRenderingAndTextures(): Unit

    def registerEventHandlers(): Unit

    def registerKeybindings(): Unit

    def registerRenderers(): Unit

    def playSound(soundName: String,
                  xCoord: Float,
                  yCoord: Float,
                  zCoord: Float,
                  volume: Float,
                  pitch: Float): Unit

    def spawnParticle(particleName: String,
                      xCoord: Double,
                      yCoord: Double,
                      zCoord: Double,
                      xVelocity: Double,
                      yVelocity: Double,
                      zVelocity: Double): Unit
}
