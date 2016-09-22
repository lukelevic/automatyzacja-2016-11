//package com.example.tests;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

//        driver = new ChromeDriver(@"C:\Workspace\automatyzacja-2016-11\src\main\resources");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

//    @Test
//    public void testSelenium() throws Exception {
//        driver.get(baseUrl + "/wp-admin");
//        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
//        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
//        driver.findElement(By.id("wp-submit")).click();
//        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
//        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
//    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void testAddNewPost() {
        // login
        driver.get(baseUrl + "/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();

        // add new post
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();

        Random randomId = new Random();
        String title = "Moj nowy post"+String.valueOf(randomId.nextInt(1000000));
        String post ="Test Lukasz"+String.valueOf(randomId.nextInt(1000000));

        driver.findElement(By.xpath(".//*[@id='title']")).sendKeys(title);
        driver.findElement(By.xpath(".//*[@id='content-html']")).click();
        driver.findElement(By.xpath(".//*[@id='content']")).sendKeys(post.toString());
        driver.findElement(By.xpath(".//*[@id='publish']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //log out
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();

        //check if post is added
        driver.get("https://automatyzacja2016.wordpress.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue("Nie ma postu o tytule: "+title.toString(),driver.getPageSource().contains(title.toString()));
        Assert.assertTrue("Nie ma postu o tresci: "+post.toString(),driver.getPageSource().contains(post.toString()));
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
