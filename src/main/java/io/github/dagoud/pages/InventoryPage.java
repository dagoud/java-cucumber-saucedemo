package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends Page{

    private final By productsHeading = By.cssSelector("span.title");

    public InventoryPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void waitForPage(){
        waitForPage(productsHeading, 10);
    }
}
