package rst.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdminMainPage extends Page{
    public AdminMainPage(WebDriver driver) {
        super(driver);
    }
    public AddPostPage goToAddPost() {

        clickElement(By.xpath("/*//*[@id=\"menu-posts\"]/a/div[2]"));
        clickElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1/a"));
        return new AddPostPage(driver);
    }

}
