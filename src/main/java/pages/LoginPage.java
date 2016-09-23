package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(id="user_login")
    private WebElement usernameInput;

    @FindBy(id="user_pass")
    private WebElement passwordInput;

    @FindBy(id = "wp-submit")
    private WebElement signInButton;

    private final static String USERNAME = "szkolenieautomatyzacja";
    private final static String PASSWORD = "QW12qw12";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "wp-login.php");
    }

    public AdminPage signIn() {
        usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        signInButton.click();

        return new AdminPage(driver);
    }
}
