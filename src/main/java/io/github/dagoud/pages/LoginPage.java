package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page{

    private final By loginLogo = By.className("login_logo");
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void waitForPage(){
        waitForPage(loginLogo, 10);
    }

    public void enterLoginDetails(String username){
        textInput(username, usernameInput);
        textInput(USER_PASSWORD, passwordInput);
    }

    public void clickLoginButton(){
        WebElement loginButtonElement = waitForElementToBeClickable(loginButton, 10);
        loginButtonElement.click();
        waitUntilNotVisible(loginButton, 10);
    }



}
