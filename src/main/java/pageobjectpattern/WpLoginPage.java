package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpLoginPage extends WpPage {
    private static String urlPath = "/wp-login.php?redirect_to=https%3A%2F%2Fautomatyzacja2016.wordpress.com%2Fwp-admin%2F&reauth=1";
    private static String userLogin = "szkolenieautomatyzacja";
    private static String userPass = "QW12qw12";

    public WpLoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + urlPath);
    }

    public WpMainAdminPage logIn() {
        insert(By.id("user_login"), userLogin);
        insert(By.id("user_pass"), userPass);
        click(By.id("wp-submit"));
        return new WpMainAdminPage(driver);
    }
}
