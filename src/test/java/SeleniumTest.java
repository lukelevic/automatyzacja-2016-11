import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {



       System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(); //("C:\\chromedriver.exe");
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.get(baseUrl + "wp-admin");
        driver.manage().window().maximize();



    }

    @Test
    public void ShouldLoginWithCredential() throws Exception {
        //given
        insert(By.id("user_login"), "szkolenieautomatyzacja");
        insert(By.id("user_pass"), "QW12qw12");
        click(By.id("wp-submit"));



        //when
        //TODO login(user,password)


        //than


        click(By.xpath(".//*[@id='wp-admin-bar-ab-new-post']/a"));
      //  Thread.sleep(3000);
        xpathSendKey(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[3]/div/textarea");
     // Thread.sleep(3000);
        click(By.xpath(" .//*[@id='primary']/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/button[1]"));
       // Thread.sleep(1000);
        click(By.xpath(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[2]/div/div/a"));
       // Thread.sleep(3000);
        Assert.assertTrue("jakubg", driver.getPageSource().contains("jakubg"));
        System.out.println("Jest git!!!!!!!!!!!!!!!!!");




    }

    private void xpathSendKey(String xpathExpression ) {
        WebDriverWait waitN = new WebDriverWait(driver, 10);
        waitN.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        driver.findElement(By.xpath(xpathExpression)).sendKeys("jakubg");
    }

    private void click(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    private void insert(By login, String text) {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(text);
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
