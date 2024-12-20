package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

import static utilities.JavaHelpers.convertPriceToDouble;

public class ProductPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='inventory_item']//button")
    private List<WebElement> buttons;

    @FindBy(id = "emptyState")
    private WebElement emptyState;


    /**
     * Get number of product
     */
    public int getNumberOfProduct() {
        return productList.size();
    }

    /**
     * Get number of product
     * As example
     */
    public Boolean isEmptyProductVisible() {
        return selenium.isElementAppeared(emptyState);
    }

    /**
     * Verifies if all products in the list are visible on the page.
     *
     * @return true if all products are visible, otherwise false.
     */
    public boolean isProductListDisplayed() {
        return productList.stream().allMatch(selenium::isElementAppeared);
    }


    /**
     * Verifies that all "Add to Cart" buttons are visible on the page.
     *
     * @return true if all "Add to Cart" buttons are displayed, otherwise false.
     */
    public boolean isAddToCartButtonDisplayed() {
        return buttons.stream().allMatch(selenium::isElementAppeared);
    }


    /**
     * Verifies if the "Remove" button for a specific product in the cart is displayed.
     *
     * @param index The index of the product in the cart list.
     * @return The text of the "Remove" button, which confirms its visibility.
     */
    public String isRemoveCartButtonDisplayed(int index) {
        return selenium.getText(buttons.get(index));
    }


    /**
     * Clicks on the "Add to Cart" button for the specified product.
     *
     * @param index The index of the product in the product list.
     * @throws InterruptedException If the thread is interrupted during the execution of the click action.
     */
    public void clickOnAddToCartButton(int index) throws InterruptedException {
        selenium.clickOn(buttons.get(index));
    }


    /**
     * Retrieves the names of all products in the product list.
     *
     * @return A list of product names as strings.
     */
    public List<String> getProductList() {
        return productList.stream().map(WebElement::getText).toList();
    }


    /**
     * Retrieves the list of product prices.
     *
     * @return A list of product prices as doubles.
     */
    public List<Double> getProductPriceList() {
        return priceList.stream().map(price -> convertPriceToDouble(price.getText())).toList();
    }
}
