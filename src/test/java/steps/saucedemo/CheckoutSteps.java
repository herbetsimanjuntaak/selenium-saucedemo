package steps.saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.CheckoutCompletePO;
import pageobject.CheckoutDetailPO;
import pageobject.CheckoutPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

import java.util.List;

import static utilities.JavaHelpers.totalPrice;

public class CheckoutSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final CheckoutPO checkout = new CheckoutPO(driver);
    private final CheckoutDetailPO checkoutDetail = new CheckoutDetailPO(driver);
    private final ProductPO product = new ProductPO(driver);
    private final CheckoutCompletePO checkoutComplete = new CheckoutCompletePO(driver);

    @When("user input firstname {string}")
    public void user_input_firstname(String firstName) {
        checkout.enterFirstName(firstName);
    }

    @When("user input lastname {string}")
    public void user_input_lastname(String lastName) {
        checkout.enterLastName(lastName);
    }

    @When("user input postal code {string}")
    public void user_input_postal_code(String postalCode) {
        checkout.enterPostalCode(postalCode);
    }

    @Then("verify first name is {string} last name is {string} and postal code is {string}")
    public void verify_first_name_is_last_name_is_and_postal_code_is(String firstName, String lastName, String postalCode) {
        Assert.assertEquals(checkout.getFirstName(), firstName, "firstName is not match!");
        Assert.assertEquals(checkout.getLastName(), lastName, "lastName is not match!");
        Assert.assertEquals(checkout.getPostalCode(), postalCode, "postalCode is not match!");
    }

    @When("user click on continue button")
    public void user_click_on_continue_button() throws InterruptedException {
        checkout.clickOnContinueButton();
    }

    @Given("user successfully checkout using firstname {string} lastname {string} and postal code {string}")
    public void userSuccessfullyCheckoutUsingFirstnameLastnameAndPostalCode(String firstName, String lastName, String postalCode) {
        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);
    }

    @Then("system display product with quantity and total price")
    public void system_display_product_with_quantity_and_total_price() {
        Assert.assertTrue(checkoutDetail.isQuantityProductVisible(), "The product quantities are not visible");
        Assert.assertTrue(product.isProductListDisplayed(), "The product list is not displayed");

        List<Double> priceList = product.getProductPriceList();
        Double totalPrice = totalPrice(priceList);
        Double tax = checkoutDetail.getTax();
        Double expectedPrice = Math.round((totalPrice + tax) * 100.0) / 100.0;
        Double actualPrice = checkoutDetail.getFinalPrice();

        Assert.assertEquals(actualPrice, expectedPrice, "The product price is incorrect");
    }

    @When("user click on cancel button")
    public void user_click_on_cancel_button() throws InterruptedException {
        checkoutDetail.clickOnCancelButton();
    }

    @Given("user click on finish button")
    public void user_click_on_finish_button() throws InterruptedException {
        checkoutDetail.clickOnFinishButton();
    }

    @Then("system display order complete")
    public void system_display_order_complete() {
        Assert.assertTrue(checkoutComplete.isChecklistImageVisible(), "The order confirmation message is incorrect.");

        String titleMessage = "Thank you for your order!";
        Assert.assertEquals(checkoutComplete.getTitleMessageText(), titleMessage, "Title message is incorrect.");

        String detailMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(checkoutComplete.getDetailMessageText(), detailMessage, "Detail message is incorrect.");
        Assert.assertTrue(checkoutComplete.isBackButtonVisible(), "Back Home button is not displayed");

    }

    @When("user click on back home button")
    public void user_click_on_back_home_button() throws InterruptedException {
        checkoutComplete.clickBackButton();
    }
}
