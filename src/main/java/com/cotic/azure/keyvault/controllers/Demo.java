package com.cotic.azure.keyvault.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.security.keyvault.secrets.SecretClient;

@RestController
public class Demo {

    //@Value("${mes}")
    //private String mes;

    // Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
    private final SecretClient secretClient;

    public Demo(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    @GetMapping("mes")
    public String mes() {
        //System.out.println("mes: " + mes);
        return secretClient.getSecret("mes").getValue();
    }
}
