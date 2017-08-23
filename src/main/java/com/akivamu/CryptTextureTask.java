package com.akivamu;

import com.akivamu.gdx.exe.SimpleXorCryptoEncryptor;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;

public class CryptTextureTask extends DefaultTask {
    public String[] ignoreExtensions = new String[]{"atlas", "json"};
    public String secret;
    public String[] inputPaths;

    @TaskAction
    public void action() {
        if (secret == null || secret.length() == 0) {
            throw new GradleException("Must input secret key!");
        }

        if (ignoreExtensions == null) {
            ignoreExtensions = new String[0];
        }

        System.out.println("Encrypting texture");
        System.out.println("    Secret     : " + secret);
        System.out.print("    Ignore    : ");
        for (String ignore : ignoreExtensions) {
            System.out.print(ignore + " ");
        }
        System.out.println();


        for (String inputPath : inputPaths) {
            System.out.println("Encrypting path: " + inputPath);
            SimpleXorCryptoEncryptor.process(secret, inputPath, inputPath, ignoreExtensions);
        }
    }
}
