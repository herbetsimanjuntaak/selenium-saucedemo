package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumHelpers;

public class HeaderPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public HeaderPO(WebDriver driver) {
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

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    private WebElement sortingDropdown;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerButton;

    /**
     * Click on the cart icon to navigate to the cart page.
     *
     * @throws InterruptedException if there is an interruption while waiting for the click process.
     */
    public void clickOnCartIcon() throws InterruptedException {
        selenium.clickOn(cartIcon);
    }

    /**
     * Retrieves the text of the cart page title.
     *
     * @return The cart page title text.
     */
    public String getTitle() {
        return selenium.getText(title);
    }


    /**
     * Select on drop down sorting
     *
     * @return Select of drop down
     */
    public Select selectDropDown() {
        return new Select(sortingDropdown);
    }

    /**
     * Clicks the burger menu button.
     *
     * @throws InterruptedException if interrupted during execution.
     */
    public void clickOnBurgerMenuButton() throws InterruptedException {
        selenium.clickOn(burgerButton);
    }

    /**
     * Checks if the burger menu button is visible.
     *
     * @return true if the burger menu button is visible, false otherwise.
     */
    public boolean isBurgerMenuButtonVisible() {
        return selenium.isVisibleInViewport(burgerButton);
    }

}
