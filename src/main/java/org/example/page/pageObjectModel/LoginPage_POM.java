package org.example.page.pageObjectModel;
//import org.example.wailt.WailtHelper;
import org.apache.logging.log4j.Logger;
import org.example.utils.LoggerHelper;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;

public class LoginPage_POM {

    // Contains
    // Page Locaters
    WebDriver driver;
    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LoggerHelper.getLogger(LoginPage_POM.class);

    private By username = By.id("cust_user_id");
    private By password = By.id("passwd");
    private By signButton = By.xpath("//button[@type='button']");
    private By error_message = By.xpath("//div[contains(text(),'Invalid username or password.')]");



    // Page Action
    // LoginT

    public String loginToSBInvalidCreds(String user, String pwd)  throws FileNotFoundException{

//        driver.get("https://scoreboard-ui.jaigovinda7.com/login");
        driver.get(PropertyReader.readkey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.xpath("//div[contains(text(),'Invalid username or password.')]"));

        String error_msg_text = error_msg.getText();
        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        return error_msg_text;

    }
    public void loginToSBCorrectCreds(String user, String pwd) throws FileNotFoundException {
        driver.get(PropertyReader.readkey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
    }



//    public void loginToSBCorrectCreds(String user, String pwd) throws FileNotFoundException {
//        driver.get(PropertyReader.readkey("url"));
//
//        // ✅ Wait for username field
//        WebElement userField = WailtHelper.waitForVisibility(driver, username);
//        userField.clear();
//        userField.sendKeys(user);
//
//        // ✅ Wait for password field
//        WebElement passField = WailtHelper.waitForVisibility(driver, password);
//        passField.clear();
//        passField.sendKeys(pwd);
//
//        // ✅ Wait for button to be clickable
//        WebElement loginBtn = WailtHelper.waitForClickable(driver, signButton);
//        loginBtn.click();
//
//        System.out.println("✅ Login submitted with username: " + user);
//    }

}

