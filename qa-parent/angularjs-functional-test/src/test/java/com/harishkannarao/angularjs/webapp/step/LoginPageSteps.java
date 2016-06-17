package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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

    @And("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String userName) throws Throwable {
        loginPage.enterUserName(userName);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password) throws Throwable {
        loginPage.enterPassword(password);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Given("^I go to login page$")
    public void iGoToLoginPage() throws Throwable {
        loginPage.navigate();
    }

    @And("^I click on \"([^\"]*)\" link on login page$")
    public void iClickOnLinkOnLoginPage(String linkText) throws Throwable {
        loginPage.clickOnLink(linkText);
    }
}
