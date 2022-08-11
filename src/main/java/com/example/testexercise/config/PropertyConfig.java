package com.example.testexercise.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class PropertyConfig {
    private String basePath;
    private String delimiter;
    private String usersDirName;
}
