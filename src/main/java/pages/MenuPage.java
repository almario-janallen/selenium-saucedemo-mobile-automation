package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MenuPage {
    private AppiumDriver driver;

    //locators
    private final By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"View menu\"]");
    private final By loginButton = By.xpath("//android.widget.TextView[@content-desc=\"Login Menu Item\"]");
    private final By logoutButton = By.xpath("//android.widget.TextView[@content-desc=\"Logout Menu Item\"]");
    private final By appLogo = By.xpath("//android.widget.ImageView[@content-desc=\"App logo and name\"]");


    public MenuPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void goToLogin(){
        driver.findElement(menuButton).click();
        driver.findElement(loginButton).click();
    }

    public void logout(){
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
    }

    public void openMenu(){
        driver.findElement(menuButton).click();
    }
}
