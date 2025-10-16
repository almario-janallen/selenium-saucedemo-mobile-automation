package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage{
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
        super(driver);
    }

    public boolean isProductTitleDisplayed(){
        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isMenuDisplayed(){
        return driver.findElement(menuButton).isDisplayed();
    }

    public void scrollDown() {
        swipeVertical(0.5, 0.2, 0.5);
    }

    public List<String> getProductList() {
        List<String> allProductNames = new ArrayList<>();
        boolean endOfListReached = false;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By productLocator = By.id("com.saucelabs.mydemoapp.android:id/titleTV");

        while(!endOfListReached) {
            // Wait for visible products
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
            List<WebElement> visibleProducts = driver.findElements(productLocator);

            // Add only new products
            for(WebElement product: visibleProducts) {
                String name = product.getText().trim();
                if (!allProductNames.contains(name)) {
                    allProductNames.add(name);
                }
            }

            int beforeScrollCount = allProductNames.size();

            // Scroll down using BasePage method
            scrollDown();

            // Wait again for newly visible items
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
            List<WebElement> afterScrollProducts = driver.findElements(productLocator);

            int afterScrollCount = afterScrollProducts.size();

            if (beforeScrollCount == afterScrollCount) {
                endOfListReached = true;
            }
        }

        System.out.println(allProductNames);
        return allProductNames;
    }
}


//Not yet finished. Need to check how to put all products in the array instead of replacing it.