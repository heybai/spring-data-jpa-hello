package com.heybai.exx.springdata.hello;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath*:/spring/persist-test-seed-ctx.xml"})
public abstract class AbstractSeedTest extends AbstractTestNGSpringContextTests {

    @Autowired Flyway flyway;

    @BeforeMethod public void beforeMethod() {
        flyway.clean();
        flyway.migrate();
    }

}
