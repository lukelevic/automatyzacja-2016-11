package pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpAdminPostListPage extends WpAdminPage {
    private static String urlPath = "/wp-admin/edit.php";

    public WpAdminPostListPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + urlPath);
    }

    public boolean isPostOnTheList(String title) {
        return driver.findElement(By.xpath("//a[@aria-label='" + title + "']")).getText() == title;
    }
}
