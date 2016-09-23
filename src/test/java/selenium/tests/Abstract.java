package selenium.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Abstract {
    protected String baseUrl = "https://automatyzacja2016.wordpress.com/";
    protected WebDriver driver;

    public Abstract(WebDriver driver) {
        this.driver = driver;

    }


    public WebElement w8(String path) {
        WebElement w8 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        return w8;
    }



}
