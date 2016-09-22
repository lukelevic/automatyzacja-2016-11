import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class Scenario {
    protected WebDriver driver;
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(); //("C:\\chromedriver.exe");
        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.get(baseUrl + "wp-admin");
        driver.manage().window().maximize();

    }
    protected void login() {
        insert(By.id("user_login"), "szkolenieautomatyzacja");
        insert(By.id("user_pass"), "QW12qw12");
        click(By.id("wp-submit"));
    }
    protected void assertAddPost() {
        click(By.xpath(" .//*[@id='primary']/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/button[1]"));
        // Thread.sleep(1000);
        click(By.xpath(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[2]/div/div/a"));
        // Thread.sleep(3000);

        Assert.assertTrue("jakubg", driver.getPageSource().contains("jakubg"));
        System.out.println("Jest git!!!!!!!!!!!!!!!!!");
    }

    protected void addNewPost() {
        click(By.xpath(".//*[@id='wp-admin-bar-ab-new-post']/a"));
        //  Thread.sleep(3000);
        xpathSendKey(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[3]/div/textarea");
    }

    protected void xpathSendKey(String xpathExpression) {
        WebDriverWait waitN = new WebDriverWait(driver, 6);
        waitN.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        driver.findElement(By.xpath(xpathExpression)).sendKeys("jakubg");
    }

    protected void click(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    protected void insert(By login, String text) {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(text);
    }


    //than


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
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



