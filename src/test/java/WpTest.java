import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @BeforeClass
    public static void setUp() throws Exception {
        insert(By.id("user_login"), userLogin);
        insert(By.id("user_pass"), userPass);
        click(By.id("wp-submit"));
    }

    protected static void click(By by) {
        driver.findElement(by).click();
    }

    protected static void insert(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected static void findByClassName(String className) { driver.findElement(By.className(className)); };

    @AfterClass
    public static void tearDown() throws Exception {
//      this is a nasty hack, debug required
        Thread.sleep(3000);
        click(By.className("masterbar__item-me"));
        click(By.className("me-sidebar__signout-button"));
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
