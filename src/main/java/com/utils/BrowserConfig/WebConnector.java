package com.utils.BrowserConfig;

import com.utils.ConfigUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class WebConnector {

    Properties browser= new Properties();
    ConfigUtil reader;

    public Properties setConfig()
    {   reader = new ConfigUtil();
        return browser = reader.getConfig("config");
    }

    protected static GetWebDriver basePage;
    public static WebDriver driver = null;
    public WebDriverWait wait;

    @BeforeClass
    public WebDriver openBrowser(){

        if (driver==null) {

            String browserType = setConfig().getProperty("browser");

            if (browserType.equalsIgnoreCase("Mozilla")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver_linux");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "Geckodriver" + File.separator + "geckodriver");
                }
                driver = new FirefoxDriver();
            } else if (browserType.equalsIgnoreCase("Chrome")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriverli");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver.exe");
                    System.out.println(System.getProperty("os.name"));
                } else {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver");
                }
                driver = new ChromeDriver();
            } else if (browserType.equalsIgnoreCase("headlesschrome")){

                if (System.getProperty("os.name").equals("Linux")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriverli");
                } else if (System.getProperty("os.name").contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver.exe");
                    System.out.println(System.getProperty("os.name"));
                } else {
                    System.setProperty("webdriver.chrome.driver", "ChromeDriver" + File.separator + "chromedriver");
                }
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
                driver = new ChromeDriver(options);
            }
            basePage = new GetWebDriver();
            basePage.setWebDriver(driver);
            wait = new WebDriverWait(driver,30);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    @AfterSuite
    public void teardown () {
        driver.quit();
    }
}
