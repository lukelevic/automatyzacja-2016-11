package PageTest;

import Pages.*;
import Pages.LogOutPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.UUID;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-23.
 */
public class PostaTest {

    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(); //("C:\\chromedriver.exe");
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.get(baseUrl + "wp-admin");
        driver.manage().window().maximize();

    }

    @Test
    public void shouldBePosibleToAddNewPost() throws InterruptedException {
        LogInPage lp = new LogInPage(driver);
        lp.openPage();
        MainPage mp = lp.logIn();

        PostaPage pp = mp.goToPostPage();
        String title = UUID.randomUUID().toString();
        pp.addNewPost(title);

        PostPreviewPage ppp = pp.goToPostPreviewPage();
        Assert.assertTrue(ppp.isPostAdded(title));
        LogOutPage lop = ppp.logOut();

    }
        @After
        public void tearDown()  {
            driver.quit();


    }


}
