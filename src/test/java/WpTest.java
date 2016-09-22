import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class WpTest {
    protected static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static String baseUrl = "https://automatyzacja2016.wordpress.com/";
    private static String userLogin = "szkolenieautomatyzacja";
    private static String userPass = "QW12qw12";
    private static int timeInterval = 30;

    protected static void click(By by) {
        driver.findElement(by).click();
    }

    protected static void insert(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected static void closeAlertIfOpened() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {};
    }

    protected static void assertThatPostIsAdded() {
        Assert.assertTrue(driver.findElement(By.className("notice__content")).isDisplayed());
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeInterval, TimeUnit.SECONDS);
        driver.get(baseUrl + "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
        insert(By.id("user_login"), userLogin);
        insert(By.id("user_pass"), userPass);
        click(By.id("wp-submit"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        click(By.className("masterbar__item-me"));
        closeAlertIfOpened();
        click(By.className("me-sidebar__signout-button"));
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
