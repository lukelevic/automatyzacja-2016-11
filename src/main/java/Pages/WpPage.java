package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpPage {

    public WebDriver driver;
    public String baseUrl = "https://automatyzacja2016.wordpress.com/";

    public WpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String s) {
        driver.get(baseUrl + s);
    }

    public WpPage()
    {

    }

    public WebElement findElement(String type, String selector)
    {
        if ( type == "id" ) {
            return driver.findElement(By.id(selector));
        }
        else if ( type == "xpath" ) {
            return driver.findElement(By.xpath(selector));
        }
        else return null;
    }

    public void findByXpathAndClick(String s)
    {
        findElement("xpath", s).click();
    }

    public void findByIdAndClick(String s)
    {
        findElement("id", s).click();
    }

}
