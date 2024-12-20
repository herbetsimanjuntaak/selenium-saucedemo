package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPO(WebDriver driver) {
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

    @FindBy(id = "login_button_container")
    private WebElement loginForm;

    @FindBy(name = "user-name")
    private WebElement usernameEditText;

    @FindBy(name = "password")
    private WebElement passwordEditText;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement loginMessageError;

    /**
     * Enters the provided username into the username input field.
     *
     * @param username The username to be entered into the input field.
     */
    public void enterUsername(String username) {
        selenium.enterText(usernameEditText, username, true);
    }

    /**
     * Enters the provided password into the password input field.
     *
     * @param password The password to be entered into the input field.
     */
    public void enterPassword(String password) {
        selenium.enterText(passwordEditText, password, true);
    }

    /**
     * Clicks on the login button to initiate the login process.
     *
     * @throws InterruptedException If the thread is interrupted during the click operation.
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }

    /**
     * Get login message error
     *
     * @return error message
     */
    public String getLoginMessageError() {
        return selenium.getText(loginMessageError);
    }

    /**
     * Login form is visible
     *
     * @return true if login form is visible
     */
    public boolean isLoginFormVisible() {
        return selenium.isElementAppeared(loginForm);
    }
}
