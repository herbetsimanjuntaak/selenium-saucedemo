package steps.saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobject.HeaderPO;
import pageobject.ProductPO;
import utilities.ThreadManager;

import java.util.List;
import java.util.NoSuchElementException;

import static utilities.JavaHelpers.*;

public class HeaderSteps {
    private final WebDriver driver = ThreadManager.getDriver();
    private final HeaderPO header = new HeaderPO(driver);
    private final ProductPO product = new ProductPO(driver);


    @Given("user click on burger menu button")
    public void user_click_on_burger_menu_button() throws InterruptedException {
        header.clickOnBurgerMenuButton();
    }

    @When("user click on icon cart")
    public void user_click_on_icon_cart() throws InterruptedException {
        header.clickOnCartIcon();
    }

    @Then("system display {string} title")
    public void system_display_title(String title) {
        Assert.assertEquals(header.getTitle(), title, "The page title is incorrect.");
    }

    @When("user selects {string} from the sorting options")
    public void user_selects_from_the_sorting_options(String sortBy) {
        Select dropdown = header.selectDropDown();
        List<WebElement> options = dropdown.getOptions();
        boolean optionExists = options.stream().anyMatch(opt -> opt.getText().equals(sortBy));
        if (optionExists) {
            dropdown.selectByVisibleText(sortBy);
        } else {
            throw new NoSuchElementException("Sorting option is not available in the dropdown.");
        }

    }

    @Then("the product list should be displayed in {string} order product name")
    public void the_product_list_should_be_displayed_in_order_product_name(String sortBy) {
        List<String> actualNames = product.getProductList();
        boolean isSorted = sorting(actualNames, sortBy);
        Assert.assertTrue(isSorted, "The product list is not sorted in" + sortBy + "order");
    }

    @Then("the product list should be displayed in {string} order by price")
    public void the_product_list_should_be_displayed_in_order_by_price(String sortBy) {
        List<Double> actualPrice = product.getProductPriceList();
        boolean isSorted = sorting(actualPrice, sortBy);
        Assert.assertTrue(isSorted, "The product list is not sorted in" + sortBy + "order");
    }

}
