package org.runestar.client.plugins.std.debug

import org.runestar.client.game.raw.Client.accessor
import org.runestar.client.plugins.Plugin
import org.runestar.client.plugins.PluginSettings

class DevOptionsDebug : Plugin<DevOptionsDebug.Settings>() {

    override val defaultSettings = Settings()

    override fun start() {
        super.start()
        if (settings.boundingBoxes2D.draw) {
            accessor.drawBoundingBoxes2D = true
        }
        if (settings.boundingBoxes3D.draw) {
            accessor.drawBoundingBoxes3D = true
        }
        if (settings.boundingBoxes3D.drawAll) {
            accessor.boundingBox3DDrawMode = accessor.boundingBox3DDrawMode_all
        } else {
            accessor.boundingBox3DDrawMode = accessor.boundingBox3DDrawMode_mouseOver
        }
        if (settings.displayFps) {
            accessor.displayFps = true
        }
        if (!settings.useBoundingBoxes3D) {
            accessor.useBoundingBoxes3D = false
        }
        if (settings.boundingBoxes2D.drawObjectGeometry) {
            accessor.drawObjectGeometry2D = true
        }
        if (settings.numberMenuOptions) {
            accessor.numberMenuOptions = true
        }
    }

    override fun stop() {
        super.stop()
        accessor.drawBoundingBoxes2D = false
        accessor.drawBoundingBoxes3D = false
        accessor.displayFps = false
        accessor.useBoundingBoxes3D = true
        accessor.drawObjectGeometry2D = false
        accessor.numberMenuOptions = false
    }

    class Settings : PluginSettings() {

        val boundingBoxes3D = ThreeD()
        val boundingBoxes2D = TwoD()
        val displayFps = false
        val useBoundingBoxes3D = true
        val numberMenuOptions = false

        class ThreeD {
            val draw = false
            val drawAll = true
        }

        class TwoD {
            val draw = false
            val drawObjectGeometry = false
        }
    }
}