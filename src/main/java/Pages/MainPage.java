package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public PostPage goToPostPage() {
        click(By.xpath(".//*[@id='wp-admin-bar-ab-new-post']/a"));

        return new PostPage(driver);
    }
}
