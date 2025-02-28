package io.github.dagoud.steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.github.dagoud.driver.DriverFactory.cleanUpDriver;
import static io.github.dagoud.driver.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setup(){
        getDriver();
    }

    @After
    public void tearDown(){
        cleanUpDriver();
    }

}
