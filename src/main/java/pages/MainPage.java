package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")).click();
    }
}
