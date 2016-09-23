package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void publishPost(String title, String postContent) {

        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("content")).sendKeys(postContent);
        driver.findElement(By.id("publish")).click();
    }

    public void open() {
        driver.get(baseUrl + "wp-admin/post-new.php");
    }
}
