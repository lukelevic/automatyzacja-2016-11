package Pages;


import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class LoginPage extends WpPage {

    public static final String loginFieldSelector = "user_login";
    public static final String PasswordFieldSelector = "user_pass";
    public static final String LoginSubmitButton = "wp-submit";

    public static final String login = "szkolenieautomatyzacja";
    public static final String password = "QW12qw12";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openURL("/wp-login.php");
    }

    public AdminPage login() {

        findElement("id", loginFieldSelector).clear();
        findElement("id", loginFieldSelector).sendKeys(login);
        findElement("id", PasswordFieldSelector).clear();
        findElement("id", PasswordFieldSelector).sendKeys(password);
        findByIdAndClick(LoginSubmitButton);

        return new AdminPage(driver);
    }

}
