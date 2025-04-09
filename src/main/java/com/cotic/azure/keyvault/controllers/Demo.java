package com.cotic.azure.keyvault.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.secrets.SecretClient;

@RestController
public class Demo {

    // Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
    private final SecretClient secretClient;

    public Demo(SecretClient secretClient) {
        this.secretClient = secretClient;
    }
    /*
    @GetMapping("signo")
    public String signo() {
        return secretClient.getSecret("signo").getValue();
    }

    @GetMapping("distrito")
    public String distrito() {
        return secretClient.getSecret("distrito").getValue();
    }

    @GetMapping("edad")
    public String edad() {
        return secretClient.getSecret("edad").getValue();
    }
    */

    @GetMapping("mes")
    public String edad() {
        return secretClient.getSecret("mes").getValue();
    }
}
