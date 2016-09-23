package SeleniumTest;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Scenario {

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }


}
