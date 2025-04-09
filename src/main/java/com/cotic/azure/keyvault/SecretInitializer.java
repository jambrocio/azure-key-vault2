package com.cotic.azure.keyvault;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import com.azure.security.keyvault.secrets.SecretClient;

import jakarta.annotation.PostConstruct;

@Configuration
public class SecretInitializer {

    private static final String DYNAMIC_PROPERTIES_SOURCE_NAME = "application";

    @Autowired
    private SecretClient secretClient;

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private ConfigurableEnvironment environment;

    @PostConstruct
    public void init() {
        String secretValue = secretClient.getSecret("mes").getValue();
        System.out.println("mes 2: " + secretValue);
        //context.getEnvironment().getPropertySources().addFirst(new MapPropertySource("application", Collections.singletonMap("db.password", secretValue)));

        MutablePropertySources propertySources = environment.getPropertySources();
        if (!propertySources.contains(DYNAMIC_PROPERTIES_SOURCE_NAME)) {
            Map<String, Object> dynamicProperties = new HashMap<>();
            dynamicProperties.put("db.password", secretValue);
            propertySources.addFirst(new MapPropertySource(DYNAMIC_PROPERTIES_SOURCE_NAME, dynamicProperties));
        }
    }
    
}
