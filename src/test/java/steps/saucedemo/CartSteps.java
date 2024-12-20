package steps.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.CartPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

import java.util.List;

import static utilities.JavaHelpers.*;
import static utilities.JavaHelpers.saveValue;

public class CartSteps {
    private final WebDriver driver = ThreadManager.getDriver();
    private final CartPO cart = new CartPO(driver);
    private final ProductPO product = new ProductPO(driver);


    @When("user click continue shopping")
    public void user_click_on_continue_shopping() throws InterruptedException {
        cart.clickOnContinueShoppingButton();
    }

    @Then("The removed product should not appear in the cart")
    public void the_removed_product_should_not_appear_in_the_cart() {
        List<String> productInCart = product.getProductList();
        String removedProduct = (String) getValue("removedProduct");
        Assert.assertFalse(productInCart.contains(removedProduct), "Removed productInCart is still in the cart.");
    }

    @When("user user clicks on a random Remove button from the cart page")
    public void userUserClicksOnARandomRemoveButtonFromTheCartPage() throws InterruptedException {
        Integer totalProductAdd = (Integer) getValue("productNumber");

        if (totalProductAdd > 0) {
            int randomIndex = getRandomIndex(totalProductAdd);

            List<String> productNames = product.getProductList();
            String removedProduct = productNames.get(randomIndex);
            saveValue("removedProduct", removedProduct);
            saveValue("productNumber", randomIndex);
            cart.clickOnRemoveButton(randomIndex);

        } else {
            Assert.assertTrue(product.isEmptyProductVisible(), "Empty State Not Visible");
        }
    }

    @And("user click the product checkout button")
    public void userClickTheProductCheckoutButton() throws InterruptedException {
        cart.clickOnCheckoutButton();
    }
}
