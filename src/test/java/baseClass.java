import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-22.
 */
public class baseClass {
    public  WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public static final String loginFieldSelector = "user_login";
    public static final String PasswordFieldSelector = "user_pass";
    public static final String LoginSubmitButton = "wp-submit";

    public static final String PostTitleSelector = "//textarea[@class='textarea-autosize editor-title__input']";
    public static final String PostTextSelector = "//textarea[@id='tinymce-1']";
    public static final String NewPostSelector = "//li[@id='wp-admin-bar-ab-new-post']";
    public static final String NewPostPublishSelector = "//button[@class='editor-ground-control__publish-button button is-primary']";
    public static final String NoticeSelector = "//div[@class='notice__content']";

    public static final String AvatarSelector = "//img[@class='gravatar']";
    public static final String LogoutSelector = "//button[@class='button me-sidebar__signout-button is-compact']";
    public static final String MainContent = "//div[@id='content']";

    @Before
    public void setUp() throws Exception {
        // driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        baseUrl = "https://automatyzacja2016.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        login ("szkolenieautomatyzacja", "QW12qw12");
    }

    @Test
    public void testWordpress() throws Exception {
        driver.get(baseUrl + "/wp-login.php");
        driver.findElement(By.id(loginFieldSelector)).clear();
        driver.findElement(By.id(loginFieldSelector)).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id(PasswordFieldSelector)).clear();
        driver.findElement(By.id(PasswordFieldSelector)).sendKeys("QW12qw12");
        driver.findElement(By.id(LoginSubmitButton)).click();

        // driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        // driver.findElement(By.xpath("//button[contains(@class, 'sign-out')]")).click();
    }

    public void openURL(String url)
    {
        driver.get(baseUrl + url);
    }

    public WebElement findElement(String type, String selector)
    {
        if ( type == "id" ) {
            return driver.findElement(By.id(selector));
        }
        else if ( type == "xpath" ) {
            return driver.findElement(By.xpath(selector));
        }
        else return null;
    }

    public void findByXpathAndClick(String s)
    {
        findElement("xpath", s).click();
    }

    public void findByIdAndClick(String s)
    {
        findElement("id", s).click();
    }

    public void login(String login, String Password)
    {
        openURL("/wp-login.php");
        findElement("id", loginFieldSelector).clear();
        findElement("id", loginFieldSelector).sendKeys(login);
        findElement("id", PasswordFieldSelector).clear();
        findElement("id", PasswordFieldSelector).sendKeys(Password);
        findByIdAndClick(LoginSubmitButton);
    }

    public void logout()
    {
        findElement("xpath", LogoutSelector).click();
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
