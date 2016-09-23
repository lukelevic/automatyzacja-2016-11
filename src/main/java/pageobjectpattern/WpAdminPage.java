package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
abstract class WpAdminPage extends WpPage {
    public WpAdminPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        click(By.cssSelector("img.avatar.avatar-32"));
        click(By.cssSelector("button.ab-sign-out"));
        driver.quit();
    }
}
