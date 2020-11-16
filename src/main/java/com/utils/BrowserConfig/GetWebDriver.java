package com.utils.BrowserConfig;

import org.openqa.selenium.WebDriver;

public class GetWebDriver {
    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver) {

        GetWebDriver.driver = driver;
    }


}
