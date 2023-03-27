package com.ait.qa21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class letCarWorkTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://ilcarro.web.app/let-car-work");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCss(){
        driver.findElement(By.cssSelector("#pickUpPlace"));
        driver.findElement(By.cssSelector("#make"));
        driver.findElement(By.cssSelector("#model"));
        driver.findElement(By.cssSelector(".input-container"));
        driver.findElement(By.cssSelector(".input-label"));
        driver.findElement(By.cssSelector("#year"));
        driver.findElement(By.cssSelector("#fuel"));
        driver.findElement(By.cssSelector("#seats"));
        driver.findElement(By.cssSelector("#class"));
        driver.findElement(By.cssSelector("#serialNumber"));
    }
    @Test
public void findElementByXpath(){
        driver.findElement(By.xpath("//*[@id='pickUpPlace']"));
        driver.findElement(By.xpath("//*[@id='make']"));
        driver.findElement(By.xpath("//*[@id='model']"));
        driver.findElement(By.xpath("//*[@class='input-container']"));
        driver.findElement(By.xpath("//*[@class='input-label']"));
        driver.findElement(By.xpath("//*[@id='year']"));
        driver.findElement(By.xpath("//*[@id='fuel']"));
        driver.findElement(By.xpath("//*[@id='seats']"));
        driver.findElement(By.xpath("//*[@id='class']"));
        driver.findElement(By.xpath("//*[@id='serialNumber']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



