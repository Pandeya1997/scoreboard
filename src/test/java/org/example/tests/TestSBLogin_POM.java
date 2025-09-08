package org.example.tests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import org.example.page.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.example.wailt.WailtHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class TestSBLogin_POM {
    private static final Logger logger = LogManager.getLogger(TestSBLogin_POM.class);
    @BeforeMethod
    public void setup() {
        logger.info("🚀 Initializing WebDriver using DriverManager...");
        DriverManager.init(); // ✅ start driver based on config.properties
    }

    @AfterMethod
    public void tearDown() {
        logger.info("🛑 Closing WebDriver...");
        DriverManager.down();// ✅ quit driver after each test
    }

    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginNegativeSB01()throws FileNotFoundException  {
//        WebDriver driver = new EdgeDriver();
        WebDriver driver = DriverManager.getDriver();
        logger.info("🚀 Starting test: testLoginNegativeSB01 with invalid credentials");
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username"),PropertyReader.readkey("invalid_password"));
        logger.info("🔍 Captured error message: {}", error_msg_text);
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        logger.info("✅ Test passed: Invalid login correctly displayed error message.");

        driver.quit();

    }

    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginNegativeSB02()throws FileNotFoundException  {
//        WebDriver driver = new EdgeDriver();
        WebDriver driver = DriverManager.getDriver();
        logger.info("🚀 Starting test: testLoginNegativeSB02 with another invalid login");
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username"),PropertyReader.readkey("invalid_password"));
        logger.info("🔍 Captured error message: {}", error_msg_text);
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        logger.info("✅ Test passed: Error message displayed as expected.");
        driver.quit();
    }
    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginPostiveSB03() throws FileNotFoundException {
//        WebDriver driver = new EdgeDriver();
        WebDriver driver = DriverManager.getDriver();
        logger.info("🚀 Starting test: testLoginPostiveSB03 with random invalid credentials");
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username1"),PropertyReader.readkey("invalid_password1"));
        logger.info("🔍 Captured error message: {}", error_msg_text);
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        logger.info("✅ Test passed: Invalid login correctly rejected.");
        driver.quit();

    }



    @Test(description = "Verify login with valid credentials")
    @Description("This test verifies that login  with correct username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginPositiveSB04() throws FileNotFoundException {
//        WebDriver driver = new EdgeDriver();
        WebDriver driver = DriverManager.getDriver();
        logger.info("🚀 Starting test: testLoginPositiveSB04 with valid credentials");
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);

        // ✅ Login with valid credentials
        loginPage_pom.loginToSBCorrectCreds(
                PropertyReader.readkey("username"),
                PropertyReader.readkey("password")
        );

        // ✅ Use WaitHelper to wait for user role element
        WebElement loggedinUser = WailtHelper.waitForVisibility(
                driver, By.xpath("(//span[@class='h6 user-role'])[1]")
        );
        logger.info("🔍 Logged in user role: {}", loggedinUser.getText());

        // ✅ Assert successful login
        Assert.assertTrue(loggedinUser.getText().contains("Admin"),
                "Login failed! Expected role 'Admin' but found: " + loggedinUser.getText());

        logger.info("✅ Test passed: Login successful with Admin role.");

        driver.quit();
    }

}
