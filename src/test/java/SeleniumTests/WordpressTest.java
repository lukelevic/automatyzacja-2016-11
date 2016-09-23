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
public class WordpressTest extends Scenario {

    @Test
    public void testUserShouldLogin() throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        AdminPage ap = lp.login();

        Assert.assertTrue(ap.isLogged());
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




}
