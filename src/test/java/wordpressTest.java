import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.util.Random;

import static org.junit.Assert.fail;

public class wordpressTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    @Test
    public void testWordpress() throws Exception {
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();

        // driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        // driver.findElement(By.xpath("//button[contains(@class, 'sign-out')]")).click();
    }

    @Test
    public void testAddPost() throws Exception {

        Random generator = new Random();
        int a = generator.nextInt(50000);

        String expectedPostString = "Post testowy z selenium: " + a;

        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();

        driver.findElement(By.xpath("//li[@id='wp-admin-bar-ab-new-post']")).click();

        driver.findElement(By.xpath("//textarea[@class='textarea-autosize editor-title__input']")).sendKeys("Tytuł testowy z selenium");
        System.out.println(expectedPostString);
        driver.findElement(By.xpath("//textarea[@id='tinymce-1']")).sendKeys(expectedPostString);

        driver.findElement(By.xpath("//button[@class='editor-ground-control__publish-button button is-primary']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notice__content']")));

        driver.findElement(By.xpath("//img[@class='gravatar']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//button[@class='button me-sidebar__signout-button is-compact']")).click();
        Thread.sleep(2000);

        driver.get(baseUrl);

        Thread.sleep(2000);

        String content =  driver.findElement(By.xpath("//div[@id='content']")).getText();
        Assert.assertTrue(content.contains(expectedPostString));

        Thread.sleep(1000);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
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
