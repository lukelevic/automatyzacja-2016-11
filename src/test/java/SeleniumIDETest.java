package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumIDETest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\automatyzacja-2016-11\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    @Test
//    public void testWordpress() throws Exception {
//        driver.get(baseUrl + "/wp-login.php");
//        driver.findElement(By.id("user_login")).clear();
//        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
//        driver.findElement(By.id("user_pass")).clear();
//        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
//        driver.findElement(By.id("wp-submit")).click();
//        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
//        driver.findElement(By.xpath("//button[contains(@class, 'sign-out')]")).click();
//    }

    @Test
    public void testAddPostAndCheck() throws Exception {
        int randNum = (int) (Math.random() * 1000);
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")).click();
        driver.findElement(By.xpath("//div[@class='wrap']//a[text()='Dodaj nowy']")).click();
        driver.findElement(By.xpath("//div[@id='titlediv']//input[@id='title']")).sendKeys("nowy pościk "+randNum);
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys("nowa tresc");
        driver.findElement(By.xpath("//input[@id='publish']")).click();
        driver.findElement(By.xpath("//li[@id='menu-posts']//a[@class='wp-first-item current']")).click();
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'sign-out')]")).click();
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id='content']//a[contains(text(),'nowy pościk')]")).click();
        assertTrue(driver.getTitle().contains("nowy pościk "+randNum));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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
