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
    @FindBy(id = "cust_user_id")
    private WebElement username;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement signButton;
    @FindBy(xpath = "//div[contains(text(),'Invalid username or password.')]")
    private WebElement error_msg;
    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    // Page Actions
    public String loginTOSBInvalidCreds() throws FileNotFoundException {

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
