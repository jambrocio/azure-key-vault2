package com.cotic.azure.keyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

@Configuration
public class SecretClientConfiguration {
    
    @Value("${spring.cloud.azure.keyvault.uri}")
    private String keyVaultUri;

    @Bean
    public SecretClient secretClient() {
        return new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }
}
