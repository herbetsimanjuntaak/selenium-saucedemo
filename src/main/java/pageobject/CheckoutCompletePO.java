package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class CheckoutCompletePO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CheckoutCompletePO (WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "(//img[@alt='Pony Express'])")
    private WebElement checklistImage;

    @FindBy(className = "complete-header")
    private WebElement completeMessage;

    @FindBy(className = "complete-text")
    private WebElement descriptionMessage;

    @FindBy(id = "back-to-products")
    private WebElement backButton;

    /**
     * Checks if the checklist image is visible on the page.
     *
     * @return {@code true} if the checklist image is visible, otherwise {@code false}.
     */
    public boolean isChecklistImageVisible() {
        return selenium.isElementAppeared(checklistImage);
    }

    /**
     * Retrieves the cart item count or completion message text.
     *
     * @return The text representing the cart item count or completion message.
     */
    public String getTitleMessageText() {
        return selenium.getText(completeMessage);
    }

    /**
     * Retrieves the description message text.
     *
     * @return The text of the description message.
     */
    public String getDetailMessageText() {
        return selenium.getText(descriptionMessage);
    }

    /**
     * Checks if the back button is visible on the page.
     *
     * @return {@code true} if the back button is visible, otherwise {@code false}.
     */
    public boolean isBackButtonVisible() {
        return selenium.isElementAppeared(backButton);
    }

    /**
     * Clicks on the back button to navigate to the previous page or abort the current action.
     *
     * @throws InterruptedException If the thread is interrupted during the click operation.
     */
    public void clickBackButton() throws InterruptedException {
        selenium.clickOn(backButton);
    }
}
