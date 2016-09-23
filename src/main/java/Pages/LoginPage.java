package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
       driver.get(BASE_URL+"/wp-admin");
    }

    public AdminPage signIn() {
        insert(By.id("user_login"),"szkolenieautomatyzacja");
        insert(By.id("user_pass"),"QW12qw12");
        click(By.id("wp-submit"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.titleContains("Kokpit"));

        return new AdminPage(driver);
    }

    public void logOut() {
        click(By.cssSelector("img.avatar.avatar-32"));

        WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ab-sign-out")));

        click(By.cssSelector("button.ab-sign-out"));
    }
}
