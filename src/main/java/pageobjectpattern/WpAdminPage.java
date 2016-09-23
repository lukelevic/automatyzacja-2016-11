package pageobjectpattern;

import org.openqa.selenium.Alert;
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
        click(By.className("masterbar__item-me"));
        click(By.className("me-sidebar__signout-button"));
        driver.quit();
    }
}
