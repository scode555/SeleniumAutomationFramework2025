package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        test = ExtentReportManager.createTest("Login Test");

        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigating to URL");

        test.info("Adding Credentials");
        loginPage.enterUsername("admin@yourstore.com");
        loginPage.enterPassword("admin");

        test.info("Clicking on Login Button");
        loginPage.clickLogin();
        test.info("Verifying page title");
        System.out.println("Title of the page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Just a moment...");

        test.pass("Login Successful");
    }

    @Test
    public void testLoginWithInvalidCredentials() {

        test = ExtentReportManager.createTest("Login Test with Invalid Credentials");

        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigating to URL");

        test.info("Adding Credentials");
        loginPage.enterUsername("admin1234@yourstore.com");
        loginPage.enterPassword("admin123");

        test.info("Clicking on Login Button");
        loginPage.clickLogin();
        test.info("Verifying page title");
        System.out.println("Title of the page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Just a moment...123");

        test.pass("Login Successful");
    }

}
