package com.TenPearls.demoproject.Tests;

import com.TenPearls.demoproject.PageClasses.Chapter1_Page;
import com.TenPearls.demoproject.PageClasses.Home_Page;
import com.utils.BrowserConfig.WebConnector;
import org.testng.annotations.Test;

public class Chapter1_Tests extends WebConnector {
    Home_Page home_page = new Home_Page();
    Chapter1_Page chapter1_page = new Chapter1_Page();

    @Test
    public void accessChapter1(){
        home_page.OpenBaseURL();
        home_page.assertTextOnHome();
        home_page.clickChapter("chapter1");
        chapter1_page.assertTextOnChapter1();
        chapter1_page.clickHomePage();
        home_page.assertTextOnHome();
    }
}
