package com.heybai.ex.springdata.hello;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;

public class MyFlyway extends Flyway {

    private Action initAction;

    @PostConstruct
    public void iii() {
        if (initAction == Action.CLEAN || initAction == Action.CLEAN_MIGRATE) {
            clean();
        }
        if (initAction == Action.MIGRATE || initAction == Action.CLEAN_MIGRATE) {
            migrate();
        }
    }

    public static enum Action {
        NONE,
        CLEAN,
        CLEAN_MIGRATE,
        MIGRATE
    }

    public void setInitAction(Action initAction) {
        this.initAction = initAction;
    }
}
