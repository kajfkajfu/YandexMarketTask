package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utill.DriverSingleTone;
import utill.WaitElement;

public class YandexMarketMainPage {
    private final WebDriver driver = DriverSingleTone.getDriver();
    private final By catalogButton = By.xpath("//button[@id='catalogPopupButton']");

    public void clickOnCatalog() {
        WaitElement.untilAppearLongTime(driver, catalogButton);
        driver.findElement(catalogButton).click();
    }
}
