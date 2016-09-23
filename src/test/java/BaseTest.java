import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class BaseTest {
    protected WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected String newTitle;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected String setRandomTitle(String title) {
        Random generator = new Random();
        int i = generator.nextInt(10000);
        newTitle = title + i;

        return newTitle;
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
