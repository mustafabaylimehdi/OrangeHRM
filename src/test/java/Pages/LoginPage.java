package Pages;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By loginText = By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");
    By loginButton = By.cssSelector("button[type='submit']");

    By requiredMessageUsername = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)");
    By requiredMessagePassword = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(3)");
    By usernameField = By.cssSelector("input[placeholder='Username']");
    By passwordField = By.cssSelector("input[placeholder='Password']");
    By invalidCredentials = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    By dashBoard = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By myInfoButton = By.cssSelector("a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void verifyUserAtHomePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = driver.findElement(loginText);
        String textTitle = loginTitle.getText();
        assertEquals(textTitle, "Login");
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void checkRequiredMessage() {
        elementHelper.checkVisible(requiredMessageUsername);
        elementHelper.checkVisible(requiredMessagePassword);
    }

    public void falseUsernamePassword() {
        driver.findElement(usernameField).click();
        elementHelper.sendKey(usernameField, "abcdefg");
        driver.findElement(passwordField).click();
        elementHelper.sendKey(passwordField, "123456");
    }

    public void checkInvalidCredentials() {
        WebElement element = driver.findElement(invalidCredentials);
        String invalidCredentialsMessage = element.getText();
        assertEquals(invalidCredentialsMessage, "Invalid credentials");
    }

    public void correctUsernamePassword() {
        driver.findElement(usernameField).click();
        elementHelper.sendKey(usernameField, "Admin");
        driver.findElement(passwordField).click();
        elementHelper.sendKey(passwordField, "admin123");
    }

    public void checkSuccessfulLogin() {
        WebElement dashBoardTitle = driver.findElement(dashBoard);
        String dashBoardText = dashBoardTitle.getText();
        assertEquals(dashBoardText, "Dashboard");
    }

    public void clickToLoginButton() {
        driver.findElement(myInfoButton).click();
    }
}
