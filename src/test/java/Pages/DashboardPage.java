package Pages;

import static org.testng.AssertJUnit.assertEquals;

import io.cucumber.java.hu.De;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class DashboardPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By myInfoButton = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1) > span:nth-child(2)");
    By saveButton = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']");
    By newNameSurnameChecker = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickToMyInfoButton() {
        driver.findElement(myInfoButton).click();
    }

    public void changeNameAndSurname() {
        WebElement username = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        username.sendKeys(Keys.CONTROL + "a");
        username.sendKeys(Keys.DELETE);
        username.sendKeys("Ali");

        WebElement surname = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        surname.sendKeys(Keys.CONTROL + "a");
        surname.sendKeys(Keys.DELETE);
        surname.sendKeys("Aliyev");
    }

    public void clickToSaveButton() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,350)");
        driver.findElement(saveButton).click();
    }

    public void checkNewNameAndSurname() {
        driver.findElement(myInfoButton).click();
        WebElement newNameAndSurname = driver.findElement(newNameSurnameChecker);
        String newNameSurnameText = newNameAndSurname.getText();
        assertEquals(newNameSurnameText, "Mehdi Mustafabayli");
    }
}
