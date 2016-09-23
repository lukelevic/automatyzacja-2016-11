package rst.wordpress;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Scenario {

    public WebDriver driver;
    public String baseUrl;

    @Before
    public void Setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void Quit(){
        driver.quit();
    }


}
