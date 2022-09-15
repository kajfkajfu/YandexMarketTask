package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utill.JsonTestDataParser;

public class FirstTestCase extends BaseTest {
    private final String MIN_PRICE = JsonTestDataParser.getTestData("minPrice");
    private final String MAX_PRICE = JsonTestDataParser.getTestData("maxPrice");
    private final String PRODUCER = JsonTestDataParser.getTestData("producer");

    @Test
    private void shouldReturnNotepadsWithSpecifiedNameAndPricesWhenSetSearchParameters() throws InterruptedException {
        yandexMarketMainPage.clickOnCatalog();
        catalogPage.moveToComputers();
        catalogPage.clickOnNotepads();
        laptopsPage.clickOnShowAllProducers();
        laptopsPage.findProducer(PRODUCER);
        laptopsPage.clickOnProducer(PRODUCER);
        laptopsPage.addMinPrice(MIN_PRICE);
        laptopsPage.addMaxPrice(MAX_PRICE);
        laptopsPage.clickOnShowButton();
        Thread.sleep(1000);
        laptopsPage.scroll();
        Assert.assertTrue(laptopsPage.isPricesFromPageValid(MIN_PRICE, MAX_PRICE));
        Assert.assertTrue(laptopsPage.isProducersFromPageValid(PRODUCER));
    }
}
