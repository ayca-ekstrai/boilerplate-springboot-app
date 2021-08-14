package io.ekstrai.apps.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan // required for constructor binding
public class BoilerplateAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateAppApplication.class, args);
    }

}
