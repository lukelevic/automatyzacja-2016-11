import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
        Date date= new java.util.Date();
        String postTitle = "new post" + date;
        driver.get(baseUrl + "wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
        driver.get(baseUrl + "wp-admin/post-new.php");
        driver.findElement(By.id("title")).sendKeys(postTitle);
        driver.findElement(By.id("content")).sendKeys("new message bla bla bla bla bla bla bla bla");
        driver.findElement(By.id("publish")).click();
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")).click();
        driver.get(baseUrl);
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + postTitle.substring(0, postTitle.length() - 5) + "')]"));

        driver.navigate().refresh();
        Assert.assertTrue("Text " + postTitle + " not found!", list.size() > 0);
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
