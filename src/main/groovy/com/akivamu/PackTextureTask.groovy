package com.akivamu

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.tools.texturepacker.TexturePacker
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PackTextureTask extends DefaultTask {
    String inputPath
    String outputPath
    String atlasName
    TexturePacker.Settings settings

    // Default setting
    Texture.TextureFilter filterMin = Texture.TextureFilter.Linear
    Texture.TextureFilter filterMag = Texture.TextureFilter.Linear
    boolean duplicatePadding = true
    int maxWidth = 1024
    int maxHeight = 1024

    @TaskAction
    def action() {
        println "Packing texture"
        println "    Input     : " + inputPath
        println "    Output    : " + outputPath
        println "    Atlas name: " + atlasName

        if (settings == null) {
            settings = new TexturePacker.Settings()
            settings.filterMin = filterMin
            settings.filterMag = filterMag
            settings.duplicatePadding = duplicatePadding
            settings.maxWidth = maxWidth
            settings.maxHeight = maxHeight
        }

        TexturePacker.process(settings, inputPath, outputPath, atlasName)
    }
}
