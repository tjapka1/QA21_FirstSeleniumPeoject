package com.ait.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumLocatorTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://ilcarro.web.app");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void startFindLocatorsTest(){
        WebElement findByID = driver.findElement(By.id("city"));
        WebElement findByClass = driver.findElement(By.className("input-label"));
        WebElement findByName =driver.findElement(By.name("viewport"));
        WebElement findByLinkText =driver.findElement(By.linkText("Let the car work"));
        System.out.println(findByLinkText.getText());
        WebElement findByPartialLinkText= driver.findElement(By.partialLinkText("car"));
        System.out.println(findByPartialLinkText.getText());
   }
   @Test
   public void startFindCssTest(){
       WebElement findByCss1 = driver.findElement(By.cssSelector("#city"));
       WebElement findByCss2 = driver.findElement(By.cssSelector(".input-label"));
       WebElement findByCss3 = driver.findElement(By.cssSelector("div"));

       driver.findElement(By.cssSelector("[href='/search']"));
       driver.findElement(By.cssSelector("[for='dates']"));
       driver.findElement(By.cssSelector("[for*='ates']"));
       driver.findElement(By.cssSelector("[for^='dat']"));
       driver.findElement(By.cssSelector("[for$='tes']"));

   }
   @Test
   public void startFindXpath(){
       WebElement findByXpathTag = driver.findElement(By.xpath("//div"));
       WebElement findByXpathID = driver.findElement(By.xpath("//*[@id='city']"));
       WebElement findByXpathClass = driver.findElement(By.xpath("//*[@class='input-label']"));

       //attribute -> xpath(//*[@attr='value'])
       driver.findElement(By.xpath("//*[@href='/search']"));
       driver.findElement(By.xpath("//*[@for='dates']"));

       driver.findElement(By.xpath("//*[starts-with(@for,'dat')]"));
       //contains, end on -> //*[contains(.,'...')]
       driver.findElement(By.xpath("//*[contains(.,'ate')]"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
