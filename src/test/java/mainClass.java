import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class mainClass {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String title;
    private String description;
    private Date data;
    private String reportDate;
    private String ddd;
    private String login;
    private String password;


    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        java.util.Date date = new java.util.Date();
        data = new Timestamp(date.getTime());


        String reportDate = data.toString();
        ddd = reportDate + " seba";
        System.out.println(ddd);


        description = "opis";


    }


    public void openPage() {
        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-login.php");
    }

    public void findText() {
        clickElement(".//*[@id='menu-posts']/a/div[3]");
        //driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath("//*[@id='post-search-input']")).sendKeys(ddd);
        driver.findElement(By.id("search-submit")).click();

        System.out.println(ddd);
        Assert.assertTrue(driver.getPageSource().contains(ddd));
    }

    public void open() {
        clickElement(".//*[@id='menu-posts']/a/div[3]");
        clickElement(".//*[@id='menu-posts']/ul/li[3]/a");
    }

    public void addText() {
        driver.findElement(By.id("title")).sendKeys(ddd);

        driver.findElement(By.id("content-html")).click();
        driver.findElement(By.id("content")).sendKeys(description);
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
    }

    public void logInWordpress(String login, String password) {
        clearElement(".//*[@id='user_login']");
        //driver.findElement(By.xpath(".//*[@id='user_login']")).clear();
        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys(login);
        clearElement(".//*[@id='user_pass']");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();


    }


    private void clearElement(String path) {
        driver.findElement(By.xpath(path)).clear();
    }

    private void clickElement(String pathh) {
        driver.findElement(By.xpath(pathh)).click();
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