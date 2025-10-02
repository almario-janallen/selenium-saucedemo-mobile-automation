package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductsPage {
    private AppiumDriver driver;

    private final By productTitle = By.xpath("//android.widget.TextView[@content-desc=\"title\"]");
    private final By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"View menu\"]");

    public ProductsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public boolean isProductTitleDisplayed(){
        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isMenuDisplayed(){
        return driver.findElement(menuButton).isDisplayed();
    }
}
