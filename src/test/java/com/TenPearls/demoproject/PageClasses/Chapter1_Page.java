package com.TenPearls.demoproject.PageClasses;

import com.utils.BrowserConfig.GetWebDriver;
import com.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Properties;

public class Chapter1_Page extends GetWebDriver {
    Properties config, moduleSelector;
    WebDriverWait wait;
    ConfigUtil reader;

    public Chapter1_Page(){
        reader = new ConfigUtil();
        config = reader.getConfig("config");
        moduleSelector = reader.getConfig("chapter1Selector");
    }

    public void assertTextOnChapter1(){
        wait = new WebDriverWait(driver, 20);
        String locator = moduleSelector.getProperty("idAssertTextChapter1");
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        Assert.assertEquals(element.getText(),"Assert that this text is on the page");
    }

    public void clickHomePage(){
        String locator = moduleSelector.getProperty("xpathHomePage");
        driver.findElement(By.xpath(locator)).click();
    }

}
