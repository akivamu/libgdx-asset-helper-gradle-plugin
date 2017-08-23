package com.akivamu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class PackTextureTask extends DefaultTask {
    public String inputPath;
    public String outputPath;
    public String atlasName;
    public TexturePacker.Settings settings;

    // Default setting
    public Texture.TextureFilter filterMin = Texture.TextureFilter.Linear;
    public Texture.TextureFilter filterMag = Texture.TextureFilter.Linear;
    public boolean duplicatePadding = true;
    public int maxWidth = 1024;
    public int maxHeight = 1024;

    @TaskAction
    public void action() {
        System.out.println("Packing texture");
        System.out.println("    Input     : " + inputPath);
        System.out.println("    Output    : " + outputPath);
        System.out.println("    Atlas name: " + atlasName);

        if (settings == null) {
            settings = new TexturePacker.Settings();
            settings.filterMin = filterMin;
            settings.filterMag = filterMag;
            settings.duplicatePadding = duplicatePadding;
            settings.maxWidth = maxWidth;
            settings.maxHeight = maxHeight;
        }

        TexturePacker.process(settings, inputPath, outputPath, atlasName);
    }
}
