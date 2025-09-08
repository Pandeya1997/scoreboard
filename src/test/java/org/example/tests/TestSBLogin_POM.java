package org.example.tests;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
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
    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginNegativeSB01()throws FileNotFoundException  {
        WebDriver driver = new EdgeDriver();

        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username"),PropertyReader.readkey("invalid_password"));
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        driver.quit();

    }

    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginNegativeSB02()throws FileNotFoundException  {
        WebDriver driver = new EdgeDriver();

        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username"),PropertyReader.readkey("invalid_password"));
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        driver.quit();
    }
    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginPostiveSB03() throws FileNotFoundException {
        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPage_pom = new LoginPage_POM(driver);
        String error_msg_text = loginPage_pom.loginToSBInvalidCreds(PropertyReader.readkey("invalid_username1"),PropertyReader.readkey("invalid_password1"));
        Assert.assertEquals(error_msg_text,"Invalid Username Or Password.");
        driver.quit();

    }



    @Test(description = "Verify login with valid credentials")
    @Description("This test verifies that login  with correct username/password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginPositiveSB04() throws FileNotFoundException {
        WebDriver driver = new EdgeDriver();
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

        // ✅ Assert successful login
        Assert.assertTrue(loggedinUser.getText().contains("Admin"),
                "Login failed! Expected role 'Admin' but found: " + loggedinUser.getText());

        driver.quit();
    }
}
