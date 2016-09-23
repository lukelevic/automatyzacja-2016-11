package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class PostPreviewPage extends Page {
    public PostPreviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostAdded(String title) {
        return driver.getPageSource().contains(title);



    }


    public LogOutPage logOut() {
        click(By.xpath("//*[@id='header']/a[4]/svg/g/path"));

        return new LogOutPage(driver);
    }
}
