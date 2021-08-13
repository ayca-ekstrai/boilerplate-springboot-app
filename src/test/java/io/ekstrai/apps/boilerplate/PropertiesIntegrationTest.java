package io.ekstrai.apps.boilerplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoilerplateAppApplication.class)
@TestPropertySource("classpath:cloud-test.properties")
public class PropertiesIntegrationTest {

    @Autowired
    @Qualifier("dataSource")
    private String mockDatabase;

    @Test
    public void testEnvDatabaseProperties() {
        assertEquals(mockDatabase, "user0password123");
    }
}
