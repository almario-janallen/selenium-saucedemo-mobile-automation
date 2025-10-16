package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExcelUtils;

import java.util.List;

public class ProductTest extends BaseTest{
    LoginPage loginPage;
    ProductsPage productsPage;

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        String filePath = "src/test/resources/SauceDemoMobileTestData.xlsx";
        return ExcelUtils.getExcelData(filePath,"Inventory");
    }

    @Test(dataProvider = "excelData")
    public void testVerifyProductList(String productName, String price) {
        productsPage = new ProductsPage(driver);
        List<String> productList = productsPage.getProductList();
        Assert.assertTrue(productList.contains(productName),"Expected item not found in products page: " + productName);
    }
}
