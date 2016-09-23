package rst.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminMainPage logIn(String user, String password) {

        driver.get(baseUrl + "/");
        driver.get(baseUrl + "/wp-admin");

        insertText(By.id("user_login"), "szkolenieautomatyzacja");
        insertText(By.id("user_pass"), "QW12qw12");
        driver.findElement(By.id("wp-submit")).click();


        return new AdminMainPage(driver);
    }

}
