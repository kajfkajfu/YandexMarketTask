package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utill.DriverSingleTone;
import utill.JsExecutor;
import utill.StringParser;
import utill.WaitElement;

import java.util.List;

public class LaptopsPage {
    private final WebDriver driver = DriverSingleTone.getDriver();
    private final String specifiedProducer = "//span[@class='_2rlLb']/span[text()='%s']";
    private final By infoAtTheBottomOfThePage = By.xpath("//div[@data-grabber='SearchLegalInfo']");
    private final By showButton = By.xpath("//span[@class='_20WYq _2WBB4']");
    private final By findProducerField = By.xpath("//div[@data-filter-id='7893318']//input[@class='_3qxDp']");
    private final By showAllProducersButton = By.xpath("//div[@data-filter-id='7893318']//span[@data-tid='d78fd628']");
    private final By minPriceField = By.xpath("//div[@data-filter-id='glprice']//span[@data-auto='filter-range-min']//input");
    private final By maxPriceField = By.xpath("//div[@data-filter-id='glprice']//span[@data-auto='filter-range-max']//input");
    private final By laptopsPrices = By.xpath("//div[@data-test-id='virtuoso-item-list']//span[@data-autotest-value='1']");
    private final By laptopsProducers = By.xpath("//div[@data-test-id='virtuoso-item-list']//span[@data-tid='2e5bde87']");

    public boolean isPricesFromPageValid(String minPrice, String maxPrice) {
        int min = Integer.parseInt(minPrice);
        int max = Integer.parseInt(maxPrice);
        WaitElement.untilAppear(driver, laptopsPrices);
        List<WebElement> laptops = driver.findElements(laptopsPrices);
        return laptops.stream().noneMatch(laptop -> StringParser.getPrice(laptop.getText()) < min
                || StringParser.getPrice(laptop.getText()) > max);
    }

    public boolean isProducersFromPageValid(String producer) {
        WaitElement.untilAppear(driver, laptopsProducers);
        List<WebElement> laptops = driver.findElements(laptopsProducers);
        return laptops.stream().allMatch(laptop -> laptop.getText().toLowerCase().contains(producer.toLowerCase()));
}

    public void scroll() {
        WaitElement.untilAppear(driver, infoAtTheBottomOfThePage);
        WebElement element = driver.findElement(infoAtTheBottomOfThePage);
        JsExecutor.execute(driver, element);
    }

    public void clickOnShowButton() {
        WaitElement.untilAppear(driver, showButton);
        driver.findElement(showButton).click();
    }

    public void clickOnProducer(String producer) {
        String locator = String.format(specifiedProducer, producer);
        WaitElement.untilAppear(driver, By.xpath(locator));
        driver.findElement(By.xpath(locator)).click();
    }

    public void findProducer(String producer) {
        WaitElement.untilAppear(driver, findProducerField);
        driver.findElement(findProducerField).sendKeys(producer);
    }

    public void clickOnShowAllProducers() {
        WaitElement.untilAppear(driver, showAllProducersButton);
        driver.findElement(showAllProducersButton).click();
    }

    public void addMinPrice(String price) {
        WaitElement.untilAppear(driver, minPriceField);
        driver.findElement(minPriceField).sendKeys(price);
    }

    public void addMaxPrice(String price) {
        WaitElement.untilAppear(driver, maxPriceField);
        driver.findElement(maxPriceField).sendKeys(price);
    }
}
