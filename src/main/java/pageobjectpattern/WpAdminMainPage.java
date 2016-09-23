package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpAdminMainPage extends WpAdminPage {

    public WpAdminMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/wp-admin");
    }

    public static WpPostPage clickAdminBarAddNewBlogPostButton() {
        click(By.xpath("//li[@id='wp-admin-bar-ab-new-post']//a"));
        return new WpPostPage(driver);
    }
}
