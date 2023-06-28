package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ParentClass{
    public WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //region list PageFactory
    @FindBy(id = "ematic_background_overlay")
    WebElement emanticBackground;

    @FindBy(id = "loginHeader")
    WebElement loginButton;

    @FindBy(id = "itemStatus")
    WebElement daftarTransaksiButton;

    @FindBy(name = "username")
    WebElement textBoxName;

    @FindBy(name = "password")
    WebElement textBoxPassword;

    @FindBy(name = "submitLogin")
    WebElement submitLoginButton;
    //endregion

    public void gotoTheWebsite()
    {
        driver.get("https://xxxxxxxxx.com");
    }

    public void clickEmantic()
    {
        emanticBackground.click();
    }

    public void login(String username, String password)
    {
        waitWebElement(emanticBackground);
        clickEmantic();
        loginButton.click();
        driver.switchTo().frame("loginRegisterIframe");
        textBoxName.sendKeys(username);
        textBoxPassword.sendKeys(password);
        submitLoginButton.click();
        driver.switchTo().defaultContent();
    }

    public DaftarTransaksiPage gotoDaftarTransaksiPage()
    {
        daftarTransaksiButton.click();
        DaftarTransaksiPage daftarTransaksiPage = new DaftarTransaksiPage(driver);
        return daftarTransaksiPage;
    }
}
