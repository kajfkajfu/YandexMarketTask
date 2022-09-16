package utill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class WaitElement {
    public static void untilAppear(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver
                , Integer.parseInt(Objects.requireNonNull(JsonConfigParser.getConfig("waitLongTime"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
