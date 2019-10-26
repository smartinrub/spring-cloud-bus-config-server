package com.sergiomartinrubio.clientconfigurationapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(value = MySqlProperties.class)
public class FirstClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstClientApplication.class, args);
    }
}

@RefreshScope
@RestController
@RequiredArgsConstructor
class ClientConfigurationController {

    private final MySqlProperties mySqlProperties;

    @GetMapping
    public String getProperty() {
        return mySqlProperties.getUsername() + " - " + mySqlProperties.getPassword();
    }
}
