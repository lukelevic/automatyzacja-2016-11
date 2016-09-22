/**
 * Created by Administrator on 2016-09-22.
 */

//package com.example.tests;

        import com.thoughtworks.selenium.Selenium;
        import org.openqa.selenium.By;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.WebDriver;
        import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import static org.junit.Assert.*;

        import java.util.concurrent.TimeUnit;
        import java.util.regex.Pattern;
        import static org.apache.commons.lang3.StringUtils.join;

public class seleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
       // selenium = new WebDriverBackedSelenium(driver, baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testIde() throws Exception {

        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        //driver.findElement(By.cssSelector("button.ab-sign-out")).click();
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")).click();



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
