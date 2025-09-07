package org.example.base;

import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class CommonToAllPage {

    private static final int DEFAULT_WAIT = 20; // configurable wait

    public CommonToAllPage() {
    }

    // Open different environments
    public void openVWOLoginURL(String env) {
        try {
            switch (env.toLowerCase()) {
                case "qa":
                    getDriver().get(PropertyReader.readkey("qa_url"));
                    break;
                case "preprod":
                    getDriver().get(PropertyReader.readkey("uat_url"));
                    break;
                default:
                    getDriver().get(PropertyReader.readkey("url"));
                    break;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config file not found!", e);
        }
    }

    // Actions
    public void clickElement(By locator) {
        getDriver().findElement(locator).click();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendKeys(By locator, String text) {
        getDriver().findElement(locator).sendKeys(text);
    }

    public void enterInput(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Waits
    public WebElement presenceOfElement(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement visibilityOfElement(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Element getters
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }
}
