package io.github.dagoud.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginStep {

    private WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        System.out.println("Test 1");
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        System.out.println("Test 2");
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        System.out.println("Test 3");
    }

    @Then("User will redirect to Products page")
    public void userWillRedirectToProductsPage() {
        System.out.println("Test 4");
    }
}
