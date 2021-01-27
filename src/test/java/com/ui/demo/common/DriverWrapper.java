package com.ui.demo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWrapper {
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
    private static DriverWrapper instance;
    public static WebDriver driver;
    private WebDriverWait wait;
    ChromeOptions options = new ChromeOptions();

    public static DriverWrapper getInstance() {
        if (null == instance) {
            instance = new DriverWrapper();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if(null==driver) {
            driver = getLocalDriver();
        }
        return driver;
    }


    private WebDriver getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Users//manip//demoProject//UIDemo//src//main//resources//chromedriver.exe");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    public WebDriverWait getDriverWait() {
        if (null == wait) {
            wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT_SECONDS);
        }
        return wait;
    }

    public void closeBrowser() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
        wait = null;
    }

}
