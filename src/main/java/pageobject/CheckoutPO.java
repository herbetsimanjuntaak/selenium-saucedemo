package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class CheckoutPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "first-name")
    private WebElement firstNameEditText;

    @FindBy(id = "last-name")
    private WebElement lastNameEditText;

    @FindBy(id = "postal-code")
    private WebElement postalCodeEditText;


    /**
     * Enters the provided first name into the first name input field.
     *
     * @param firstname The first name to be entered into the input field.
     */
    public void enterFirstName(String firstname) {
        selenium.enterText(firstNameEditText, firstname, true);
    }

    /**
     * Enters the provided last name into the last name input field.
     *
     * @param lastname The last name to be entered into the input field.
     */
    public void enterLastName(String lastname) {
        selenium.enterText(lastNameEditText, lastname, true);
    }

    /**
     * Enters the provided postal code into the postal code input field.
     *
     * @param postalCode The postal code to be entered into the input field.
     */
    public void enterPostalCode(String postalCode) {
        selenium.enterText(postalCodeEditText, postalCode, true);
    }

    /**
     * Clicks the "Continue Shopping" button to return to the shopping page.
     *
     * @throws InterruptedException If the thread is interrupted during the click action.
     */
    public void clickOnContinueButton() throws InterruptedException {
        selenium.clickOn(continueButton);
    }

    /**
     * Retrieves the first name.
     *
     * @return The first name as a string.
     */
    public String getFirstName() {
        return firstNameEditText.getAttribute("value");
    }

    /**
     * Retrieves the last name.
     *
     * @return The last name as a string.
     */
    public String getLastName() {
        return lastNameEditText.getAttribute("value");
    }

    /**
     * Retrieves the postal code.
     *
     * @return The postal code as a string.
     */
    public String getPostalCode() {
        return postalCodeEditText.getAttribute("value");
    }


}
