package org.UIAutomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver webDriver;
    private PropertyReader propertyReader;

    public DriverFactory(){
        propertyReader = new PropertyReader();
    }

    public WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chromeDriverPath"));
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", propertyReader.getProperty("firefoxDriverPath"));
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        return webDriver;
    }
}
