package com.ait.qa21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;
    //before - setUp
    @BeforeMethod
    public void setUp() {
        //driver = new FirefoxDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    //test
    @Test
    public void openSite() {
        System.out.println("Site opened!!!");
    }
    //after - tearDown

    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit(); //  all
        //driver.close();// only one tab
    }
}
