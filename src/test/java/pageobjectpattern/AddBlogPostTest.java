package pageobjectpattern;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static pageobjectpattern.WpPage.driver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AddBlogPostTest {
    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void shouldAddNewBlogPostTest() throws Exception {
        String title = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        String msg = "This is auto-generated test for JUnit.";

        // given
        WpLoginPage loginPage = new WpLoginPage(driver);
        loginPage.open();
        WpMainAdminPage mainAdminPage = loginPage.logIn();

        // when
        WpPostPage postPage = mainAdminPage.clickAdminBarAddNewBlogPostButton();
        postPage.addNewPostAndPublish(title, msg);

        // then
        postPage.assertNewBlogPostIsAdded();
        postPage.logOut();
    }
}
