package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DaftarTransaksiPage extends ParentClass {
    public WebDriver driver;

    public DaftarTransaksiPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //region list PageFactory
    @FindBy(xpath = "//a[@data-name='Daftar Transaksi']/div")
    WebElement daftarTransaksiTab;

    @FindBy(css = ".list-section")
    WebElement listSection;

    @FindBy(xpath = "//div[@class='type-item']/span")
    List<WebElement> listSO;
    //endregion

    public void gotoTabDaftarTransaksi() {
        daftarTransaksiTab.click();
    }

    public void getAllSODaftarTransaksi()
    {
        waitWebElement(listSection);

        for(int i = 0 ; i < listSO.size() ; i++)
        {
            System.out.println(listSO.get(i).getText().split("#")[1]);
        }
    }
}
