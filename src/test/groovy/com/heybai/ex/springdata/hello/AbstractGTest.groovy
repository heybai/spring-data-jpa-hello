package com.heybai.ex.springdata.hello

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by heybai on 6/10/14.
 */
@ContextConfiguration(locations = "classpath*:/spring/persist-test-ctx.xml")
abstract public class AbstractGTest extends Specification {

    @Autowired private Flyway flyway;

    def setup() {
        flyway.clean()
        flyway.migrate()
    }

}
