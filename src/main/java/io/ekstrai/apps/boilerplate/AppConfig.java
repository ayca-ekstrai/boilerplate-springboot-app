package io.ekstrai.apps.boilerplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public String dataSource() {

        return env.getProperty("database.username") + env.getProperty("database.password");
    }

}
