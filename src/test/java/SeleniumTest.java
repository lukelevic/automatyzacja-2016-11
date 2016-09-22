import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest extends BaseTest {

    @Before
    public void setUp() throws Exception {

//        driver = new ChromeDriver(@"C:\Workspace\automatyzacja-2016-11\src\main\resources");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void shouldLogIntoPage() throws Exception {
        open("/wp-admin");
        login("szkolenieautomatyzacja", "QW12qw12");
        Assert.assertTrue(driver.getTitle().contains("Kokpit"));
        logout();
        Assert.assertTrue(driver.getTitle().contains("WordPress.com: Create a free website or blog"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void ShouldAddNewPost() {
        String title = "Title:"+getRandomString();
        String post ="Text:"+getRandomString();

        open("/wp-admin");
        login("szkolenieautomatyzacja", "QW12qw12");

        addNewPost(title, post);

        logout();

        //check if post is added
        open("");

        WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='masthead']/hgroup/h1/a")));

        Assert.assertTrue("Nie ma postu o tytule: "+title,driver.getPageSource().contains(title));
        Assert.assertTrue("Nie ma postu o tresci: "+post,driver.getPageSource().contains(post));
    }

    private String getRandomString() {
        Random randomNumber = new Random();
        return String.valueOf(randomNumber.nextInt(1000000));
    }

    private void addNewPost(String title, String post) {
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
        driver.findElement(By.xpath(".//*[@id='title']")).sendKeys(title);
        driver.findElement(By.xpath(".//*[@id='content-html']")).click();
        driver.findElement(By.xpath(".//*[@id='content']")).sendKeys(post);
        driver.findElement(By.xpath(".//*[@id='publish']")).click();
    }


}
