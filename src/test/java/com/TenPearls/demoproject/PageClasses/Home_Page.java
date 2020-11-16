package com.TenPearls.demoproject.PageClasses;

import com.utils.BrowserConfig.GetWebDriver;
import com.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Properties;

public class Home_Page extends GetWebDriver {
    Properties config, moduleSelector;
    WebDriverWait wait;
    ConfigUtil reader;

    public Home_Page(){
        reader = new ConfigUtil();
        config = reader.getConfig("config");
        moduleSelector = reader.getConfig("homeSelector");
    }

    public void OpenBaseURL(){
        String url = config.getProperty("URL");
        driver.get(url);
    }

    public void clickChapter(String chapterName){
        String locator = moduleSelector.getProperty("xpathChapter");
        locator = locator.replace("CHAPTER_NAME", chapterName);
        driver.findElement(By.xpath(locator)).click();
    }

    public void assertTextOnHome(){
        wait = new WebDriverWait(driver, 20);
        String locator = moduleSelector.getProperty("classHomeBody");
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
        Assert.assertTrue(element.getText().contains("Below is a list of links to the examples needed in the chapters"));
    }

}
