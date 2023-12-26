package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverFactory;

public class LoginPageStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User at login page")
    public void userAtLoginPage() {
        loginPage.verifyUserAtHomePage();
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Check required message about username and password")
    public void checkRequiredMessageAboutUsernameAndPassword() {
        loginPage.checkRequiredMessage();
    }

    @When("False Username & Password")
    public void falseUsernamePassword() {
        loginPage.falseUsernamePassword();
    }

    @Then("Check Invalid Credentials Message about login page")
    public void checkInvalidCredentialsMessageAboutLoginPage() {
        loginPage.checkInvalidCredentials();
    }

    @When("Correct Username & Password")
    public void correctUsernamePassword() {
        loginPage.correctUsernamePassword();
    }

    @Then("Check Successful Login")
    public void checkSuccessfulLogin() {
        loginPage.checkSuccessfulLogin();
    }
}
