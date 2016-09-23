package Pages;
//******************** https://www.jetbrains.com/resharper/ **********************

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

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

    public void waitForElementOnPage(String name, int time) {
//        TODO:
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Wait wait = new FluentWait(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(100, MICROSECONDS)
                .ignoring(NoSuchElementException.class);

//        wait.until( ExpectedConditions.);

//        driver.getPageSource().contains(name);

        }
}
