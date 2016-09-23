package rst.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AddPostPage extends Page{
    public AddPostPage(WebDriver driver) {
        super(driver);
    }

    public void addPost(String title, String content) {
        insertText(By.xpath("/*//*[@id=\"title\"]"),title);
        insertText(By.xpath("/*//*[@id=\"content\"]"),content);
        clickElement(By.xpath("/*//*[@id=\"in-category-1680071\"]")); //kategoria

    }

    protected void insertText(By xpath, String content) {
        driver.findElement(xpath).sendKeys(content);
    }

    protected void publish() {
        clickElement(By.xpath("/*//*[@id=\"publish\"]"));

    }
}
