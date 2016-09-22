import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-22.
 */
public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;


    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    public void open(String url) {
        driver.get(baseUrl+url);

    }

    public void login(String user, String password) {
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(user);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.titleContains("Kokpit"));
    }

    public void logout() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ab-sign-out")));

        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
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
