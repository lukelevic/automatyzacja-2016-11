import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class WpAddNewPostTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static String baseUrl = "https://automatyzacja2016.wordpress.com/";
    private static String userLogin = "szkolenieautomatyzacja";
    private static String userPass = "QW12qw12";
    private static int timeInterval = 30;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, timeInterval);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeInterval, TimeUnit.SECONDS);
        driver.get(baseUrl + "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(userLogin);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(userPass);
        driver.findElement(By.id("wp-submit")).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
//        this calls alert window
//        driver.findElement(By.className("masterbar__item-me")).click();
//        driver.findElement(By.className("me-sidebar__signout-button")).click();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void wpAddNewPostTest() throws Exception {
        String title = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        String msg = "This is auto-generated test for JUnit.";

        driver.findElement(By.xpath("//li[@id='wp-admin-bar-ab-new-post']//a")).click();
        driver.findElement(By.className("editor-title__input")).sendKeys(title);
        driver.findElement(By.id("tinymce-1")).sendKeys(msg);
        driver.findElement(By.className("editor-ground-control__publish-button")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notice__content")));

        Assert.assertTrue(driver.findElement(By.className("notice__content")).isDisplayed());
//        this works
//        driver.findElement(By.className("masterbar__item-me")).click();
//        driver.findElement(By.className("me-sidebar__signout-button")).click();
    }
}
