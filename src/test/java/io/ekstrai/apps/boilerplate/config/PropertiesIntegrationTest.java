package io.ekstrai.apps.boilerplate.config;

import io.ekstrai.apps.boilerplate.BoilerplateAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoilerplateAppApplication.class)
@TestPropertySource("classpath:cloud-test.properties")
public class PropertiesIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesIntegrationTest.class);

    @Autowired
    @Qualifier("dataSource")
    private String mockDatabase;

    @Autowired
    private ImmutableConfigProperties immutableProperties;

    @Test
    public void whenEnvUsedForDatabaseProperties_thenItWorksProperly() {
        assertEquals(mockDatabase, "user0password123");
    }

    @Test
    public void immutableConfigPropertiesWorksWithConstructorBinding() {
        LOG.info(immutableProperties.getAuthMethod() + " " + immutableProperties.getUsername() + " " + immutableProperties.getPassword());
        assertThat(immutableProperties.getAuthMethod()).isEqualTo("SHA1");
        assertThat(immutableProperties.getUsername()).isEqualTo("mary");
        assertThat(immutableProperties.getPassword()).isEqualTo("password");
    }

}
