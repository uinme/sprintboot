package org.uinme.tools.springboot.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "settings", ignoreUnknownFields = true)
@PropertySource(value = "classpath:conf/settings.yml", factory = YamlPropertySourceFactory.class)
@Data
public class Settings {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
    private List<String> selectColumns;
}
