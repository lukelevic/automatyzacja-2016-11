package rst.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

/**
 * Created by Administrator on 2016-09-23.
 */
public class SinglePost extends Page{
    public SinglePost(WebDriver driver) {
        super(driver);
    }


    public void addComment(String comment) {
        clickElement(By.xpath("//*[@id=\"commentform\"]"));
        insertText(By.xpath("//*[@id=\"comment\"]"),comment);

    }

    public void publish() {
        String author = UUID.randomUUID().toString();
        insertText(By.xpath("//*[@id=\"email\"]"),"h891214@mvrht.com");
        insertText(By.xpath("//*[@id=\"author\"]"), author);

        clickElement(By.xpath("//*[@id=\"comment-submit\"]"));
    }

    public Boolean checkIfCommentIsPublished(String comment) {
        return driver.getPageSource().contains(comment);
    }
}
