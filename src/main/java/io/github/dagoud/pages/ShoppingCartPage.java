package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends Page {

    private final By productNameInCart = By.className("inventory_item_name");

    public ShoppingCartPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public String getProductNameInCart(){
        waitUntilVisible(productNameInCart, 10);
        WebElement productName = find(productNameInCart);
        return productName.getText();
    }

}
