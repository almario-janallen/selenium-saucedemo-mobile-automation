package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setApp(System.getProperty("user.dir") + "\\apks\\mda-2.2.0-25.apk");
        options.setPlatformName("Android");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    @Test
    public void sampleTest() {
        // ✅ Correct way in Appium v8+
        try{
            WebElement sauceLabsLogo = driver.findElement(AppiumBy.accessibilityId("App logo and name"));
            System.out.println("Element exists!");
        } catch (NoSuchElementException e) {
            System.out.println("Element does not exist!");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
