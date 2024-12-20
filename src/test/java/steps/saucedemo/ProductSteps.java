package steps.saucedemo;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.MenuPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

import java.util.List;

import static utilities.JavaHelpers.*;

public class ProductSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final ProductPO product = new ProductPO(driver);
    private final MenuPO menu = new MenuPO(driver);


    @Then("user views the product list")
    public void user_views_the_product_list() {
        Assert.assertTrue(product.isProductListDisplayed(), "The product list is not displayed");
    }

    @Then("system displays the Add to Cart button for all products")
    public void system_displays_the_add_to_cart_button_for_all_products() {
        Assert.assertTrue(product.isAddToCartButtonDisplayed(), "The add to Cart button is not displayed");
    }

    @And("user adds product to the cart")
    public void userAddsProductToCart() throws InterruptedException {
        int numberOfProduct = product.getNumberOfProduct();
        int randomNumberOfProduct = (int) (Math.random() * numberOfProduct);

        saveValue("productNumber", randomNumberOfProduct);
        if (numberOfProduct > 0) {
            product.clickOnAddToCartButton(randomNumberOfProduct);
        } else {
            Assert.assertTrue(product.isEmptyProductVisible(), "Empty State Not Visible");
        }
    }

    @Then("system should display {string} button for product")
    public void systemShouldDisplayButtonForProduct(String labelButton) {
        Integer number = (Integer) getValue("productNumber");
        Assert.assertEquals(product.isRemoveCartButtonDisplayed(number), labelButton, "Text not match");
    }

    @Then("number of product on cart icon equal to the number of product added previously")
    public void number_of_product_on_cart_icon_equal_to_the_number_of_product_added_previously() {
        Integer number = (Integer) getValue("productNumber");
        Assert.assertEquals(menu.getCartIconValue(), number, "cart icon value does not match the expected number of products.");
    }

    @When("user add some products randomly")
    public void user_add_some_products_randomly() throws InterruptedException {
        int numberOfProduct = product.getNumberOfProduct();
        int randomNumberOfProduct = (int) (Math.random() * numberOfProduct) + 1;
        saveValue("productNumber", randomNumberOfProduct);
        if (numberOfProduct > 0) {
            for (int i = 0; i < randomNumberOfProduct; i++) {
                product.clickOnAddToCartButton(i);
            }
        } else {
            Assert.assertTrue(product.isEmptyProductVisible(), "Empty State Not Visible");
        }
    }

    @When("user user clicks on a random Remove button from the product list")
    public void user_user_clicks_on_a_random_remove_button_from_the_product_list() throws InterruptedException {
        Integer totalProductAdd = (Integer) getValue("productNumber");

        if (totalProductAdd > 0) {
            int randomIndex = getRandomIndex(totalProductAdd);

            List<String> productNames = product.getProductList();
            String removedProduct = productNames.get(randomIndex);

            saveValue("removedProduct", removedProduct);
            product.clickOnAddToCartButton(randomIndex);
            saveValue("productNumber", totalProductAdd - 1);

        } else {
            Assert.assertTrue(product.isEmptyProductVisible(), "Empty State Not Visible");
        }
    }

}
