package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public ParentClass(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitWebElement(WebElement webElement)
    {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
