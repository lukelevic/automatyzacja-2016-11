package Pages;
//******************** https://www.jetbrains.com/resharper/ **********************

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    protected static String BASE_URL = "https://automatyzacja2016.wordpress.com";
    protected WebDriver driver;

    public Page (WebDriver driver) {
        this.driver = driver;
    }

    public void insert(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }
}
