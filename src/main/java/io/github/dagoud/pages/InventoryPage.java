package io.github.dagoud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void removeProductFromShoppingCart(Integer productNo){
        findManyAndClickWhenVisible(productRemoveFromCart, 10, productNo);
    }

    public void addProductToShoppingCartWithName(String productText){
        Integer productIndex = getProductInventoryIndex(productText);
        addProductToShoppingCart(productIndex);

        List<WebElement> listRemoveFromCartButtonsAfterClick = findMany(productRemoveFromCart);
        waitFor(ExpectedConditions.visibilityOf(listRemoveFromCartButtonsAfterClick.get(productIndex)), Duration.ofSeconds(10));
    }

    public Integer getProductInventoryIndex(String productName){
        List<WebElement> listProductNames = findMany(productNameInInventory);
        WebElement productWithName = listProductNames.stream().filter(i -> i.getText().equals(productName)).findFirst().orElseThrow(() -> new RuntimeException("Could not find product in inventory with name :" + productName));
        return listProductNames.indexOf(productWithName);
    }

}
