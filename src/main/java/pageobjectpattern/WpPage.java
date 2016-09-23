package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
abstract class WpPage {
    protected static WebDriver driver;
    protected static String baseUrl = "https://automatyzacja2016.wordpress.com/";

    public WpPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static void insert(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected static void click(By by) {
        driver.findElement(by).click();
    }
}
