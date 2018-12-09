package com.wan.config.client;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "mq")
public class MQConfig {
    private String url;
    private String username;
    private String password;
}
