package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase_RAW {
    @Test
    public void brushUp()
    {
        //region Login Automation
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://xxxxxx.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ematic_background_overlay"))));
        driver.findElement(By.id("ematic_background_overlay")).click();

        driver.findElement(By.id("loginHeader")).click();
        driver.switchTo().frame("loginRegisterIframe");
        driver.findElement(By.name("username")).sendKeys("your username");
        driver.findElement(By.name("password")).sendKeys("your password");
        driver.findElement(By.name("submitLogin")).click();
        driver.switchTo().defaultContent();
        //endregion

        //region Daftar Transaksi - get All SO
        driver.findElement(By.id("itemStatus")).click();
        driver.findElement(By.xpath("//a[@data-name='Daftar Transaksi']/div")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".list-section"))));
        List<WebElement> listSO = driver.findElements(By.xpath("//div[@class='type-item']/span"));

        for(int i = 0 ; i < listSO.size() ; i++)
        {
            System.out.println(listSO.get(i).getText().split("#")[1]);
        }
        //endregion


    }
}
