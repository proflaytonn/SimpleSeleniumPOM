package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase {
    @Test(dataProvider = "getData")
    public void brushUp(String user, String password)
    {
        WebDriver driver = new ChromeDriver();

        //region Login Automation
        HomePage homePage = new HomePage(driver);
        homePage.gotoTheWebsite();
        homePage.login(user,password);
        //endregion

        //region getAllSO
        DaftarTransaksiPage daftarTransaksiPage = homePage.gotoDaftarTransaksiPage();
        daftarTransaksiPage.gotoTabDaftarTransaksi();

        daftarTransaksiPage.getAllSODaftarTransaksi();
        //endregion
    }

    @DataProvider
    public String[][] getData()
    {
        String[][] data = {{"your first username", "your first password"},{"your second username", "your second password"}};
        return data;
    }
}
