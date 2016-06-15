package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class LoginPageSteps {

    @Inject
    private LoginPage loginPage;

    @Then("^I should be on login page$")
    public void iShouldBeOnLoginPage() throws Throwable {
        assertTrue(loginPage.isOnValidPage(), "Is not on Login page");
    }
}
