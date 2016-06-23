package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.ErrorPage;
import com.harishkannarao.angularjs.webapp.page.GenericPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.logging.LogEntries;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.testng.Assert.*;

@ApplicationScoped
public class ErrorPageSteps {

    @Inject
    private ErrorPage errorPage;
    @Inject
    private GenericPage genericPage;

    @Then("^I should be on error page$")
    public void iShouldBeOnErrorPage() throws Throwable {
        LogEntries logs = genericPage.getLogEntries();
        assertTrue(errorPage.isOnValidPage(), "Is not on error page");
    }

    @And("^I should see some error reference$")
    public void iShouldSeeSomeErrorReference() throws Throwable {
        String errorReference = errorPage.getErrorReference();
        assertNotNull(errorReference);
        assertFalse(errorReference.trim().isEmpty());
    }
}
