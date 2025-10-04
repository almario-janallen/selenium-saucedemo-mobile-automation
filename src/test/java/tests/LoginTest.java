package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void goToLoginPage(){
        MenuPage menuPage = new MenuPage(driver);
        try{
            menuPage.logout();
        }catch (Exception e){
            menuPage.goToLogin();
        }
    }

    @Test
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("bod@example.com", "10203040");

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isProductTitleDisplayed(),"User should land on Products page after login.");
    }

    @Test
    public void testLockedOutUser() {
        LoginPage login = new LoginPage(driver);
        login.login("alice@example.com","10203040");

        String errorMessage = login.getErrorMessage();
        Assert.assertTrue(!errorMessage.isEmpty(),"Expected to see error message for locked out user");
    }
}
