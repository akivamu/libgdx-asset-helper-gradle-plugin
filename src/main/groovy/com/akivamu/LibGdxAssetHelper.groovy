package com.akivamu

import org.gradle.api.Plugin
import org.gradle.api.Project

class LibGdxAssetHelper implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task("packTexture", type: PackTextureTask)
    }
}
