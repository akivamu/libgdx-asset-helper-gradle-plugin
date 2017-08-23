package com.akivamu;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LibGdxAssetHelper implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("packTexture", PackTextureTask.class);
        project.getTasks().create("cryptTexture", CryptTextureTask.class);
    }
}
