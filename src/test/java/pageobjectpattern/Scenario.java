package pageobjectpattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Scenario {
    protected static WebDriver driver;
    protected static WpLoginPage loginPage;
    protected static WpAdminMainPage mainAdminPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new WpLoginPage(driver);
        loginPage.open();
        mainAdminPage = loginPage.logIn();
    }

    @AfterClass
    public static void tearDown() {
        mainAdminPage.logOut();
        driver.quit();
    }
}
