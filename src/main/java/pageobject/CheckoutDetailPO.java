package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

import static utilities.JavaHelpers.convertPriceToDouble;

public class CheckoutDetailPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CheckoutDetailPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "((//div[@class='cart_quantity']))")
    private List<WebElement> quantityItems;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxPrice;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement finalPrice;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    /**
     * Checks if all product quantities are visible on the page.
     *
     * @return {@code true} if all product quantities are visible, otherwise {@code false}.
     */
    public boolean isQuantityProductVisible() {
        return quantityItems.stream().allMatch(selenium::isElementAppeared);
    }

    /**
     * Retrieve the tax price as a Double value.
     *
     * @return The tax price extracted and converted to a Double.
     */
    public Double getTax() {
        return convertPriceToDouble(taxPrice.getText());
    }

    /**
     * Retrieve the tax price as a Double value.
     *
     * @return The tax price as a Double.
     */
    public Double getFinalPrice() {
        return convertPriceToDouble(finalPrice.getText());
    }

    /**
     * Clicks on the cancel button to log out.
     *
     * @throws InterruptedException if the thread is interrupted during the click action.
     */
    public void clickOnCancelButton() throws InterruptedException {
        selenium.clickOn(cancelButton);
    }

    /**
     * Clicks on the finish button to log out.
     *
     * @throws InterruptedException if the thread is interrupted during the click action.
     */
    public void clickOnFinishButton() throws InterruptedException {
        selenium.clickOn(finishButton);
    }


}
