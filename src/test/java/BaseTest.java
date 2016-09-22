import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class BaseTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected String newTitle;
    protected List<WebElement> list;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void logIn(String username, String password) {
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
    }

    protected void open(String url) {
        driver.get(baseUrl + url);
    }

    protected void logOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")).click();
    }

    protected void publishPost(String postTitle, String postMessage) {
        open("wp-admin/post-new.php");

        newTitle = generateNewTitle(postTitle);
        driver.findElement(By.id("title")).sendKeys(newTitle);
        driver.findElement(By.id("content")).sendKeys(postMessage);
        driver.findElement(By.id("publish")).click();
    }

    private String generateNewTitle(String title) {
        Random generator = new Random();
        int i = generator.nextInt(10000);

        return title + i;


    }
    protected void assertPostWithTitleExists(String title) {
        list = driver.findElements(By.xpath("//*[contains(text(),'" + title + "')]"));
        driver.navigate().refresh();
        Assert.assertTrue("Text " + title + " not found!", list.size() > 0);
    }

    protected void scrollDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
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
