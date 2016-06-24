package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.logging.LogEntries;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@ApplicationScoped
public class CommonSteps {

    private static final Logger LOGGER = Logger.getLogger(CommonSteps.class.getName());
    @Inject
    private GenericPage genericPage;

    @And("^I wait for (\\d+) seconds$")
    public void I_wait_for_seconds(long seconds) throws Throwable {
        TimeUnit.SECONDS.sleep(seconds);
    }

    @And("^I print console output$")
    public void iPrintConsoleOutput() throws Throwable {
        LogEntries logEntries = genericPage.getLogEntries();

        logEntries.forEach(logEntry -> {
            LOGGER.info(logEntry.toString());
        });
    }
}
