package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpMainAdminPage extends WpAdminPage {
    public WpMainAdminPage(WebDriver driver) {
        super(driver);
    }

    public static WpPostPage clickAdminBarAddNewBlogPostButton() {
        click(By.xpath("//li[@id='wp-admin-bar-ab-new-post']//a"));
        return new WpPostPage(driver);
    }
}
