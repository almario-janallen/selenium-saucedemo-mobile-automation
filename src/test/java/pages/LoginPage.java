package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Elements
    private WebElement usernameField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Username"));
    }

    private WebElement passwordField() {
        return driver.findElement(AppiumBy.accessibilityId("test-Password"));
    }

    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
    }

    // Actions
    public void enterUsername(String username) {
        usernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField().sendKeys(password);
    }

    public void clickLogin() {
        loginButton().click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
