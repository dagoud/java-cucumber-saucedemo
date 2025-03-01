package io.github.dagoud.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.dagoud.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static io.github.dagoud.driver.DriverFactory.getDriver;

public class LoginSteps {

    static final String SAUCE_DEMO_URL = "https://www.saucedemo.com";

    private WebDriver driver = getDriver();
    private LoginPage loginPage;

    @When("User {string} logs in to the application")
    public void userLogsInToTheApplication(String username) {
        loginPage = new LoginPage(driver, SAUCE_DEMO_URL);
        loginPage.openUrl();
        loginPage.waitForPage();
        loginPage.enterLoginDetails(username);
        loginPage.clickLoginButton();
    }

    @Then("User has logged in \\(can see the logout link)")
    public void userHasLoggedInCanSeeTheLogoutLink() {
        loginPage.openBurgerMenuAndLogoutLinkIsDisplayed();
    }

}
