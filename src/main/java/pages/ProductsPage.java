package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductsPage {
    private AppiumDriver driver;

    private final By productTitle = By.xpath("//android.widget.TextView[@content-desc=\"title\"]");
    private final By menuButton = By.xpath("//android.widget.ImageView[@content-desc=\"View menu\"]");
    private final By cartButton = By.xpath("//android.widget.RelativeLayout[@content-desc=\"View cart\"]");


    private By productName(String productName) {
        return By.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\""+ productName + "\"]");
    }

    private By productPrice(String productName) {
        return By.xpath("//android.widget.TextView[@text='" + productName + "']/following-sibling::android.widget.TextView[@content-desc='Product Price']");
    }

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
