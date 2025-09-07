package org.example.page.pageFactory;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage_PF extends CommonToAllPage {
    WebDriver driver;
    // Page Locator
    @FindBy(id = "login-username")
    private WebElement username;
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement signButton;
    @FindBy(className = "notification-box-description")
    private WebElement error_msg;
    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    // Page Actions
    public String loginTOVWOInvalidCreds() throws FileNotFoundException {

        enterInput(username, PropertyReader.readkey("invalid_username"));
        enterInput(password, PropertyReader.readkey("invalid_password"));
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return error_msg.getText();
    }
}
