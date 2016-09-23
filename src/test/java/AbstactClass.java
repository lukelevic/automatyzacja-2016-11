import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AbstactClass {
    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\automatyzacja-2016-11\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void  logIn() {
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("QW12qw12");
        driver.findElement(By.id("wp-submit")).click();
    }

    public void goToNewPost() {
        driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")).click();
        driver.findElement(By.xpath("//div[@class='wrap']//a[text()='Dodaj nowy']")).click();
    }

    public void publishNewPost(String title, String content, Integer random) {
        driver.findElement(By.xpath("//div[@id='titlediv']//input[@id='title']")).sendKeys(title+" "+random);
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys(content);
        driver.findElement(By.xpath("//input[@id='publish']")).click();
    }

    public int getRandom() {
        int randNum = (int) (Math.random() * 1000);
        return randNum;
    }

    public void goToAllPostView() {
        driver.findElement(By.xpath("//li[@id='menu-posts']//a[@class='wp-first-item current']")).click();
    }

    public void logOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        w8("//button[contains(@class, 'sign-out')]").click();
    }

    public void goToHomePage() {
        driver.get(baseUrl);
    }

    public void goToPostView(String title) {
        driver.findElement(By.xpath("//div[@id='content']//a[contains(text(),'"+title+"')]")).click();
    }

    public WebElement w8(String path) {
        WebElement w8 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        return w8;
    }
}
