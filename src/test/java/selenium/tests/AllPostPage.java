package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Administrator on 2016-09-23.
 */
public class AllPostPage extends Abstract {
    public AllPostPage(WebDriver driver) {
        super(driver);
    }

    public LogOutPage logOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        w8("//button[contains(@class, 'sign-out')]").click();
        return new LogOutPage(driver);
    }
}
