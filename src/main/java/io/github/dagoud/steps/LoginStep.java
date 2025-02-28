package io.github.dagoud.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStep {

    private static final String SAUCE_DEMO_URL = "https://www.saucedemo.com";
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
        driver.get(SAUCE_DEMO_URL);
        Duration duration = Duration.ofSeconds(10);
        Wait<WebDriver> wait = new WebDriverWait(driver, duration)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        System.out.println("Test 2");

    }

    @And("User click Login button")
    public void userClickLoginButton() {
        System.out.println("Test 3");
        Duration duration = Duration.ofSeconds(10);
        WebElement loginButton = new WebDriverWait(driver, duration)
                .until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();
    }

    @Then("User will redirect to Products page")
    public void userWillRedirectToProductsPage() {
        System.out.println("Test 4");
    }
}
