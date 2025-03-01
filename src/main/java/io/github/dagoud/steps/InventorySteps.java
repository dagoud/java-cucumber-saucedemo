package io.github.dagoud.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.dagoud.pages.InventoryPage;
import org.openqa.selenium.WebDriver;

import static io.github.dagoud.driver.DriverFactory.getDriver;
import static io.github.dagoud.steps.LoginSteps.SAUCE_DEMO_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventorySteps {

    protected static final String INVENTORY_URL = "/inventory.html";

    private WebDriver driver = getDriver();
    private InventoryPage inventoryPage;

    @Then("User is on the Inventory page")
    public void userIsOnTheInventoryPage() {
        inventoryPage = new InventoryPage(driver, SAUCE_DEMO_URL + INVENTORY_URL);
        inventoryPage.waitForPage("Products", 10);
    }

    @When("User adds first product in the list to the shopping cart")
    public void userAddsFirstProductInTheListToTheShoppingCart() {
        inventoryPage.addProductToShoppingCart(0);
    }

    @Then("Cart count displayed on the cart icon is {string}")
    public void cartCountDisplayedOnTheCartIconIs(String count) {
        assertEquals(count, inventoryPage.getShoppingCartBadgeText());
    }

    @And("User has added a product to the shopping cart")
    public void userHasAddedAProductToTheShoppingCart() {
        inventoryPage.shoppingCartBadgeDisplayed();
    }

    @When("User clicks the cart icon")
    public void userClicksTheCartIcon() {
        inventoryPage.clickShoppingCartLink();
    }

    @When("User adds {string} to the shopping cart")
    public void userAddsToTheShoppingCart(String productName) {
        inventoryPage.addProductToShoppingCartWithName(productName);
    }
}
