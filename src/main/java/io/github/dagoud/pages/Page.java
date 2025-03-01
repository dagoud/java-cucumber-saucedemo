package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Page {

    static final String USER_PASSWORD = "secret_sauce";

    protected final By pageHeading = By.cssSelector("span.title");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By shoppingCartLink = By.className("shopping_cart_link");

    protected final WebDriver driver;
    private final String url;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void openUrl(){
        driver.get(getUrl());
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findMany(By locator) {
        return driver.findElements(locator);
    }

    public void findManyAndClickWhenVisible(By locator, Integer timeOutInSeconds, int index){
        waitUntilVisible(locator, timeOutInSeconds);
        findMany(locator).get(index).click();
    }

    protected void waitForPage(By locator, Integer timeoutInSeconds){
        waitUntilVisible(locator, timeoutInSeconds);
    }

    public void waitForPage(String headingText, Integer timeoutInSeconds){
        waitFor(ExpectedConditions.textToBePresentInElementLocated(pageHeading, headingText), Duration.ofSeconds(timeoutInSeconds));
    }

    protected void waitFor(ExpectedCondition<?> condition, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class);
        wait.until(condition);
    }

    protected void waitUntilVisible(By locator, Integer timeoutInSeconds) {
        Duration duration = Duration.ofSeconds(timeoutInSeconds);
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator), duration);
    }

    protected void waitUntilNotVisible(By locator, Integer timeoutInSeconds) {
        Duration duration = Duration.ofSeconds(timeoutInSeconds);
        waitFor(ExpectedConditions.invisibilityOfElementLocated(locator), duration);
    }

    protected WebElement waitForElementToBeClickable(By locator, Integer timeoutInSeconds){
        Duration duration = Duration.ofSeconds(timeoutInSeconds);
        WebElement webElement = new WebDriverWait(driver, duration)
                .until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    public void textInput(String text, By locator) {
        waitUntilVisible(locator, 20);
        find(locator).sendKeys(text);
    }

    public void openBurgerMenuAndLogoutLinkIsDisplayed(){
        WebElement burgerMenu = waitForElementToBeClickable(burgerMenuButton, 10);
        burgerMenu.click();
        waitUntilVisible(logoutLink, 10);
    }

    public String getShoppingCartBadgeText(){
        waitUntilVisible(shoppingCartBadge, 10);
        WebElement cartBadge = find(shoppingCartBadge);
        return cartBadge.getText();
    }

    public void shoppingCartBadgeDisplayed(){
        waitUntilVisible(shoppingCartBadge, 10);
    }

    public void clickShoppingCartLink(){
        WebElement cartLink = waitForElementToBeClickable(shoppingCartLink, 10);
        cartLink.click();
        waitFor(ExpectedConditions.urlContains("cart"), Duration.ofSeconds(10));
    }

}
