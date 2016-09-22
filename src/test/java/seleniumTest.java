/**
 * Created by Administrator on 2016-09-22.
 */

//package com.example.tests;

        import com.thoughtworks.selenium.Selenium;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.WebDriver;
        import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import static org.junit.Assert.*;
        import java.util.regex.Pattern;
        import static org.apache.commons.lang3.StringUtils.join;

public class seleniumTest {
    private Selenium selenium;
    private WebDriver  driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://automatyzacja2016.wordpress.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testIde() throws Exception {
        selenium.open("/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1");
        selenium.type("id=user_login", "szkolenieautomatyzacja");
        selenium.type("id=user_pass", "QW12qw12");
        selenium.click("id=wp-submit");
        selenium.waitForPageToLoad("30000");
        selenium.click("css=img.avatar.avatar-32");
        selenium.click("css=button.ab-sign-out");
        selenium.waitForPageToLoad("30000");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
