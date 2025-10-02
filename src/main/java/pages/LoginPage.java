package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class LoginPage {
    private AppiumDriver driver;

    //locators
    private final By usernameField = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");
    private final By passwordField = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]");
    private final By loginButton = By.xpath("//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]");
    private final By errorMessage = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordErrorTV\"]");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLogin();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
