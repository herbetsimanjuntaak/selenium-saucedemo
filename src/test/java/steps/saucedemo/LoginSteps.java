package steps.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.LoginPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final LoginPO login = new LoginPO(driver);
    private final SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user successfully using username {string} and password {string}")
    public void user_successfully_using_username_and_password(String username, String password) throws InterruptedException {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnLoginButton();
    }

    @Given("user access page {string}")
    public void user_access_page(String url) {
        selenium.navigateToPage(url);
    }

    @When("user input username {string}")
    public void user_input_username(String username) {
        login.enterUsername(username);
    }

    @When("user input password {string}")
    public void user_input_password(String password) {
        login.enterPassword(password);
    }

    @And("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        login.clickOnLoginButton();
    }

    @Then("system display error message {string}")
    public void system_display_error_message(String errorMessage) {
        String actualErrorMessage = login.getLoginMessageError();
        Assert.assertEquals(actualErrorMessage, errorMessage,"Error message does not match!");
    }

    @Then("system display login form")
    public void system_display_login_form() {
        Assert.assertTrue(login.isLoginFormVisible(),"Login form is not visible!");
    }
}
