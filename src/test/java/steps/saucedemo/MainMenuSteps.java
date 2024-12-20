package steps.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.HeaderPO;
import pageobject.MenuPO;
import utilities.ThreadManager;

public class MainMenuSteps {


    private final WebDriver driver = ThreadManager.getDriver();
    private final MenuPO menu = new MenuPO(driver);
    private final HeaderPO header = new HeaderPO(driver);

    @Then("system displays the burger menu")
    public void system_displays_the_burger_menu() {
        Assert.assertTrue(header.isBurgerMenuButtonVisible());
    }

    @When("user click on the All Items link in the sidebar")
    public void user_click_on_the_all_items_link_in_the_sidebar() throws InterruptedException {
        menu.clickOnAllItems();
    }


    @When("user click cross button sidebar menu")
    public void user_click_cross_button_sidebar_menu() throws InterruptedException {
        menu.clickOnCrossBurgerButton();
    }

    @Then("system not display cross burger menu button")
    public void system_not_display_cross_burger_menu_button() {
        Assert.assertFalse(menu.isCrossIconVisible(), "The cross burger menu button is visible, but it should not be displayed.");
    }

    @And("user click on logout menu")
    public void user_click_on_logout_menu() throws InterruptedException {
        menu.clickOnLogoutButton();
    }

    @Then("user should see display sidebar menu")
    public void user_should_see_display_sidebar_menu() {
        Assert.assertTrue(menu.isDisplaySidebarVisible(), "The sidebar menu is not visible as expected.");
    }

    @When("user click About link from the menu options")
    public void user_click_about_link_from_the_menu_options() throws InterruptedException {
        menu.clickOnAboutLink();
    }

    @Then("the system should redirect to {string}")
    public void the_system_should_redirect_to(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url, "The current URL does not match the expected URL.");
    }


    @Then("user click on the cart link")
    public void user_click_on_the_cart_link() throws InterruptedException {
        menu.clickOnCartIcon();
    }

    @And("user click on reset app state")
    public void userClickOnResetAppState() throws InterruptedException {
        menu.clickOnResetApp();
    }

    @Then("number of product on cart icon empty")
    public void numberOfProductOnCartIconEmpty() {
        Integer number = 0;
        Assert.assertEquals(menu.getCartIconValue(), number, "cart icon value does not match the expected number of products.");
    }
}
