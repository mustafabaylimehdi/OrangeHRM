package stepDefinitions;

import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class DashboardStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("Click to My Info Button")
    public void clickToMyInfoButton() {
        dashboardPage.clickToMyInfoButton();
    }

    @When("Change Name and Surname")
    public void changeNameAndSurname() {
        dashboardPage.changeNameAndSurname();
    }

    @When("Click to Save Button")
    public void clickToSaveButton() {
        dashboardPage.clickToSaveButton();
    }

    @Then("Check New Name and Surname")
    public void checkNewNameAndSurname() {
        dashboardPage.checkNewNameAndSurname();
    }
}
