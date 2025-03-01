package io.github.dagoud.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.dagoud.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

import static io.github.dagoud.driver.DriverFactory.getDriver;
import static io.github.dagoud.steps.LoginSteps.SAUCE_DEMO_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartSteps {
    protected static final String CART_URL = "/cart.html";

    private WebDriver driver = getDriver();
    private ShoppingCartPage shoppingCartPage;

    @Then("User lands on the shopping cart page")
    public void userLandsOnTheShoppingCartPage() {
        shoppingCartPage = new ShoppingCartPage(driver, SAUCE_DEMO_URL + CART_URL);
        shoppingCartPage.waitForPage("Your Cart", 10);
    }

    @And("Verifies the product {string} in the cart is correct")
    public void verifiesTheProductInTheCartIsCorrect(String productName) {
        assertEquals(productName, shoppingCartPage.getProductNameInCart());
    }
}
