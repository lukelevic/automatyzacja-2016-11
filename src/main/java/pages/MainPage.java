package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(css = "img.avatar.avatar-32")
    private WebElement avatar;

    @FindBy(xpath = "//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")
    private WebElement logoutButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        avatar.click();
        logoutButton.click();
    }
}
