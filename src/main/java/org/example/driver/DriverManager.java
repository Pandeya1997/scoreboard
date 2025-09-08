package org.example.driver;

import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileNotFoundException;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init() {
        String browser;
        try {
            browser = PropertyReader.readkey("browser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (browser == null || browser.isEmpty()) {
            browser = "edge"; // ✅ default browser
        }

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    throw new RuntimeException("❌ Browser not supported: " + browser);
            }
        }
    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
