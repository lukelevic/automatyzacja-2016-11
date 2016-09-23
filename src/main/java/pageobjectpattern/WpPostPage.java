package pageobjectpattern;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class WpPostPage extends WpAdminPage {
    public WpPostPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPostAndPublish(String title, String msg) {
        insert(By.className("editor-title__input"), title);
        insert(By.id("tinymce-1"), msg);
        click(By.className("editor-ground-control__publish-button"));
    }

    public void assertNewBlogPostAlertIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.className("notice__content")).isDisplayed());
    }

    public void logOut() {
        click(By.className("masterbar__item-me"));
        closeAlertIfOpened();
        click(By.className("me-sidebar__signout-button"));
        driver.quit();
    }

    private void closeAlertIfOpened() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } finally {};
    }
}
