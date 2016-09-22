import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        driver = new ChromeDriver(@"C:\Workspace\automatyzacja-2016-11\src\main\resources");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        setBaseUrl("https://automatyzacja2016.wordpress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public void open(String url) {
        driver.get(baseUrl+url);
    }

    public void login(String user, String password) {
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(user);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.titleContains("Kokpit"));
    }

    public void logout() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ab-sign-out")));

        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
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
    public String getRandomString() {
        Random randomNumber = new Random();
        return String.valueOf(randomNumber.nextInt(1000000));
    }

    public void addNewPost(String title, String post) {
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
        driver.findElement(By.xpath(".//*[@id='title']")).sendKeys(title);
        driver.findElement(By.xpath(".//*[@id='content-html']")).click();
        driver.findElement(By.xpath(".//*[@id='content']")).sendKeys(post);
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
    }
}
