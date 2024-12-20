package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

public class CartPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CartPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='item_pricebar']//button")
    private List<WebElement> removeButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    /**
     * Clicks on the "Continue Shopping" button to return to the shopping page.
     *
     * @throws InterruptedException If the thread is interrupted during the execution of the click action.
     */
    public void clickOnContinueShoppingButton() throws InterruptedException {
        selenium.clickOn(continueShoppingButton);
    }


    /**
     * Click Remove button on product
     *
     * @param index product
     */
    public void clickOnRemoveButton(int index) throws InterruptedException {
        selenium.clickOn(removeButton.get(index));
    }

    /**
     * Clicks on the "Checkout" button to initiate the checkout process.
     *
     * @throws InterruptedException If the thread is interrupted during the execution of the click action.
     */
    public void clickOnCheckoutButton() throws InterruptedException {
        selenium.clickOn(checkoutButton);
    }

}
