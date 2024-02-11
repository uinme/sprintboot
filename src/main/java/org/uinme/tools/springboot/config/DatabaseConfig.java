package org.uinme.tools.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
    @Autowired
    private Settings settings;
    
    @Bean
    public DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://" + settings.getHost() + ":" + settings.getPort() + "/" + settings.getDatabase());
        config.setUsername(settings.getUsername());
        config.setPassword(settings.getPassword());
        return new HikariDataSource(config);
    }
}
