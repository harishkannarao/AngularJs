package com.harishkannarao.angularjs.restapi.step;

import cucumber.api.java.en.And;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class CommonSteps extends BaseSteps {

    @And("^I wait for (\\d+) seconds$")
    public void I_wait_for_seconds(long seconds) throws Throwable {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
