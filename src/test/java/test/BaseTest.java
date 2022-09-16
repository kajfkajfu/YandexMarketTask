package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CatalogPage;
import pages.LaptopsPage;
import pages.YandexMarketMainPage;
import utill.DriverSingleTone;
import utill.JsonConfigParser;

public class BaseTest {
    protected WebDriver webDriver;
    protected YandexMarketMainPage yandexMarketMainPage = new YandexMarketMainPage();
    protected CatalogPage catalogPage = new CatalogPage();
    protected LaptopsPage laptopsPage = new LaptopsPage();

    @BeforeMethod
    protected void beforeMethod() {
        webDriver = DriverSingleTone.getDriver();
        webDriver.manage().window().maximize();
        webDriver.get(JsonConfigParser.getConfig("website"));
    }

    @AfterMethod
    protected void afterTest() {
//        webDriver.quit();
    }
}
