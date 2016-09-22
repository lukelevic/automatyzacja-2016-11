import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {



       System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(); //("C:\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

       // driver = new ChromeDriver();

        // driver = new FirefoxDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(baseUrl + "wp-admin");
        driver.manage().window().maximize();
    }

    @Test
    public void testSeleniumTest() throws Exception {
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();

        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-ab-new-post']/a")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("jakubg");
       //driver.findElement(By.cssSelector(".editor__header")).sendKeys("jakubg");
        Thread.sleep(3000);
        driver.findElement(By.xpath(" .//*[@id='primary']/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[2]/div/div/a")).click();

       // WebElement element = driver.findElement(By.className("entry-title"));
      //  WebElement element = driver.findElement(By.xpath(".//*[@id='post-345']/header/h1"));
        //String strng = element.getText();
       // System.out.println(strng);
        Thread.sleep(5000);
        Assert.assertTrue("jakubg", driver.getPageSource().contains("jakubg"));




    }

   // @After
   /* public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
*/
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
