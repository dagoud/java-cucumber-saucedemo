package io.github.dagoud.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.dagoud.pages.InventoryPage;
import org.openqa.selenium.WebDriver;

import static io.github.dagoud.driver.DriverFactory.getDriver;
import static io.github.dagoud.steps.LoginSteps.SAUCE_DEMO_URL;

public class InventorySteps {

    private WebDriver driver = getDriver();
    private InventoryPage inventoryPage;

    @Then("User is on the Inventory page")
    public void userIsOnTheInventoryPage() {
        inventoryPage = new InventoryPage(driver, SAUCE_DEMO_URL + "/inventory.html");
        inventoryPage.waitForPage();
    }

    @When("User adds first product in the list to the shopping cart")
    public void userAddsFirstProductInTheListToTheShoppingCart() {
    }

    @Then("Cart icon displays that a single item has been added")
    public void cartIconDisplaysThatASingleItemHasBeenAdded() {
    }
}
