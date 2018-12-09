package com.wan.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}

@RestController("/config")
class ConfigClientController {

    private DBConfig dbConfig;
    private MQConfig mqConfig;

    public ConfigClientController(DBConfig dbConfig, MQConfig mqConfig) {
        this.dbConfig = dbConfig;
        this.mqConfig = mqConfig;
    }

    @Value("${app.region}")
    private String reqion;

    @GetMapping
    String getConfig() {
        return String.format("%s : %s : %s", reqion, dbConfig, mqConfig);
    }

}