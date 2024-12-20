package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.SeleniumHelpers;

public class MenuPO {

    private static final Logger log = LoggerFactory.getLogger(MenuPO.class);
    WebDriver driver;
    SeleniumHelpers selenium;

    public MenuPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement crossButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    @FindBy(className = "bm-item-list")
    private WebElement sidebarList;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetLink;


    /**
     * Clicks on the "All Items" button.
     *
     * @throws InterruptedException if the thread is interrupted during the click operation.
     */
    public void clickOnAllItems() throws InterruptedException {
        selenium.clickOn(allItemsLink);
    }


    /**
     * Clicks on the logout button.
     *
     * @throws InterruptedException if the thread is interrupted during the click operation.
     */
    public void clickOnLogoutButton() throws InterruptedException {
        selenium.clickOn(logoutButton);
    }


    /**
     * Clicks on the cross burger button to close the menu.
     *
     * @throws InterruptedException if the thread is interrupted during the click operation.
     */
    public void clickOnCrossBurgerButton() throws InterruptedException {
        selenium.clickOn(crossButton);
    }


    /**
     * Checks if the cross burger button is visible in the viewport.
     *
     * @return true if visible, false otherwise.
     */
    public boolean isCrossIconVisible() {
        return selenium.isVisibleInViewport(crossButton);
    }


    /**
     * Checks if the sidebar list is visible within the current viewport.
     *
     * @return true if the sidebar list is visible in the viewport, false otherwise.
     */
    public Boolean isDisplaySidebarVisible() {
        return selenium.isVisibleInViewport(sidebarList);
    }


    /**
     * Clicks on the "About" link in the sidebar menu.
     *
     * @throws InterruptedException If the thread is interrupted during the execution of the click action.
     */
    public void clickOnAboutLink() throws InterruptedException {
        selenium.clickOn(aboutLink);
    }

    /**
     * Get Cart icon value
     *
     * @return int number value of cart icon
     */
    public Integer getCartIconValue() {
        try {
            return Integer.parseInt(cartIcon.getText());
        } catch (Exception e) {
            log.error("Error when parse icon cart value, e: ", e);
            return 0;
        }
    }

    /**
     * Click on Cart icon
     *
     * @throws InterruptedException If the thread is interrupted during the execution of the click action.
     */
    public void clickOnCartIcon() throws InterruptedException {
        selenium.clickOn(cartIcon);
    }

    /**
     * Clicks on the "Reset App" button.
     *
     * @throws InterruptedException if the thread is interrupted during the click operation.
     */
    public void clickOnResetApp() throws InterruptedException {
        selenium.clickOn(resetLink);
    }


}