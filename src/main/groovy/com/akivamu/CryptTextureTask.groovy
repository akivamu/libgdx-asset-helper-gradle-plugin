package com.akivamu

import com.akivamu.gdx.exe.SimpleXorCryptoEncryptor
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

class CryptTextureTask extends DefaultTask {
    String[] ignoreExtensions = ["atlas", "json"]
    String secret
    String[] inputPaths

    @TaskAction
    def action() {
        if (secret == null || secret.length() == 0) {
            throw new GradleException("Must input secret key!")
        }

        println "Encrypting texture"
        println "    Secret     : " + secret
        println "    Ignore    : " + ignoreExtensions

        for (String inputPath : inputPaths) {
            println "Encrypting path: " + inputPath
            SimpleXorCryptoEncryptor.process(secret, inputPath, inputPath, ignoreExtensions)
        }
    }
}
