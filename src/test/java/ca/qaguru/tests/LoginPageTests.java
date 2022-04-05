package ca.qaguru.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTests {
    WebDriver driver;
    public static final String BASE_URL="https://opensource-demo.orangehrmlive.com/";
    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();// chrome page launch
        driver.get(BASE_URL);//navigate to login page

    }
    @AfterMethod
    public void clear(){
        driver.quit();
    }
    @Test
    public void validLogin(){
        driver.findElement(By.xpath("//*[@id='txtUsername']"))
                .sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='txtPassword']"))
                .sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//*[@id='welcome']"));

        //Invalid login
        //String msg= driver.findElement(By.xpath("//*[@id='spanMessage']")).getTest();
        //Assert.assertEquals(msg,"Invalid credentials");

    }
}
