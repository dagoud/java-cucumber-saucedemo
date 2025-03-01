package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends Page{

    private final By productNameInInventory = By.className("inventory_item_name");
    private final By productAddToCart = By.cssSelector("[id^=\"add-to-cart\"]");
    private final By productRemoveFromCart = By.cssSelector("[id^=\"remove\"]");

    public InventoryPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void addProductToShoppingCart(Integer productNo){
        findManyAndClickWhenVisible(productAddToCart, 10, productNo);
    }

    public void addProductToShoppingCartWithName(String productText){
        List<WebElement> listProductNames = findMany(productNameInInventory);
        WebElement productWithName = listProductNames.stream().filter(i -> i.getText().equals(productText)).findFirst().orElseThrow(() -> new RuntimeException("Could not find product with name :" + productText));

        // TODO - need to loop through and get index
        WebElement productAddToCartButton = driver.findElement(RelativeLocator.with(productAddToCart).near(productWithName));
        productAddToCartButton.click();

        WebElement productRemoveFromCartButton = driver.findElement(RelativeLocator.with(productRemoveFromCart).near(productWithName));
        waitFor(ExpectedConditions.visibilityOf(productRemoveFromCartButton), Duration.ofSeconds(10));
    }

}
