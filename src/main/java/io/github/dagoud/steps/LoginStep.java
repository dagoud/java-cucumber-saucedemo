package io.github.dagoud.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.dagoud.utils.Hooks;

public class LoginStep extends BaseStep {

    public LoginStep(Hooks hooks) {
        super(hooks);
    }



    @When("User {string} logs in to the application")
    public void userLogsInToTheApplication(String username) {
        getLoginPage().openUrl();
        getLoginPage().waitForPage();
        getLoginPage().enterLoginDetails(username, "secret_sauce");
        getLoginPage().clickLoginButton();
    }

    @Then("User has logged in \\(can see the logout link)")
    public void userHasLoggedInCanSeeTheLogoutLink() {
        getLoginPage().logoutLinkIsDisplayed();
    }

}
