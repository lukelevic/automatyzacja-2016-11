package SeleniumTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Scenario {

    protected WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }


}
