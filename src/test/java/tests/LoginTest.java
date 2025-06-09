package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @DataProvider(name="LoginData")
    public Object [][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir") + "/testData/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for (int i = 1; i<rowCount; i++){
            data[i-1][0] = ExcelUtils.getCellDate(i,0); // Username
            data[i-1][1] = ExcelUtils.getCellDate(i,1); // Password
        }
        ExcelUtils.closeExcel();
        return data;

    }
    @DataProvider(name="LoginData2")
    public Object[][] getData() {
        return new Object[][]{
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"user3", "pass3"}
        };
    }

    @Test(dataProvider = "LoginData")
//    @Test
//    @Parameters({"username","password"})
    public void testValidLogin(String username, String password) {

        test = ExtentReportManager.createTest("Login Test - "+username);

        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigating to URL");

        test.info("Adding Credentials");
//        loginPage.enterUsername("admin@yourstore.com");
//        loginPage.enterPassword("admin");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        test.info("Clicking on Login Button");
        loginPage.clickLogin();
        test.info("Verifying page title");
        System.out.println("Title of the page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Just a moment...");

        test.pass("Login Successful");
    }

//    @Test
//    public void testLoginWithInvalidCredentials() {
//
//        test = ExtentReportManager.createTest("Login Test with Invalid Credentials");
//
//        LoginPage loginPage = new LoginPage(driver);
//        test.info("Navigating to URL");
//
//        test.info("Adding Credentials");
//        loginPage.enterUsername("admin1234@yourstore.com");
//        loginPage.enterPassword("admin123");
//
//        test.info("Clicking on Login Button");
//        loginPage.clickLogin();
//        test.info("Verifying page title");
//        System.out.println("Title of the page is : " + driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "Just a moment...123");
//
//        test.pass("Login Successful");
//    }

}
