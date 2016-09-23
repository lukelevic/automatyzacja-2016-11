package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdminMainPage extends Page {


    public AdminMainPage(WebDriver driver) {
        super(driver);
    }



    public NewPostPage goTOAddPost() {

        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();

        return new NewPostPage(driver);
    }
}
