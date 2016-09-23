package Pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * Created by Administrator on 2016-09-23.
 */
public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {

        this.driver = driver;}

   // public void clearElement(String path) {
    //    driver.findElement(By.xpath(path)).clear();
   // }

  //  public void clickElement(String pathh) {
   //     driver.findElement(By.xpath(pathh)).click();
  //  }

   /* @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }*/
}
