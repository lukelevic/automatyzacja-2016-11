package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private final static String USERNAME = "szkolenieautomatyzacja";
    private final static String PASSWORD = "QW12qw12";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "wp-login.php");
    }

    public AdminPage signIn() {
        driver.findElement(By.id("user_login")).sendKeys(USERNAME);
        driver.findElement(By.id("user_pass")).sendKeys(PASSWORD);
        driver.findElement(By.id("wp-submit")).click();

        return new AdminPage(driver);
    }
}
