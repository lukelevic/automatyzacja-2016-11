package SeleniumTests;

import Pages.AdminPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


/**
 * Created by Administrator on 2016-09-23.
 */
public class WordpressTest {
    
    private WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testShouldAddPostPOP() throws Exception {

        String testString;

        Random generator = new Random();
        int a = generator.nextInt(50000);
        testString = "PD Post testowy z selenium: " + a;

        LoginPage lp = new LoginPage(driver);
        lp.open();
        AdminPage ap = lp.login();

        ap.addNewPost(testString);
        ap.logOut();

        HomePage hp = new HomePage(driver);
        hp.open();
        Assert.assertTrue(hp.isPostAdded(testString));
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
