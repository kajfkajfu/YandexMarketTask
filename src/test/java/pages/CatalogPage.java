package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utill.DriverSingleTone;
import utill.WaitElement;

public class CatalogPage {
    private final WebDriver driver = DriverSingleTone.getDriver();
    private final Actions actions = new Actions(driver);
    private final By computersButton = By.xpath("//ul[@role='tablist']//li[@data-zone-data='{\"id\":\"97009164\"}']");
    private final By notePadsButton = By.xpath("//div[contains(@data-zone-data,'--noutbuki/')]");

    public void clickOnNotepads() {
        WaitElement.untilAppearLongTime(driver, notePadsButton);
        driver.findElement(notePadsButton).click();
    }

    public void moveToComputers() {
        WaitElement.untilAppearLongTime(driver, computersButton);
        actions.moveToElement(driver.findElement(computersButton)).build().perform();
    }
}
