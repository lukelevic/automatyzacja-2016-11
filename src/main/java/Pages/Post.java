package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Post extends Page {

    public Post(WebDriver driver) {
        super(driver);
    }

    public void addComment(String comment) {
        insert(By.xpath(".//*[@id='comment']"), comment);
    }

    public boolean isPostPublished(String comment) {
        if (!driver.getPageSource().contains(comment)) {
            return false;
        }
        return true;
    }

    public void publishComment() {
        click(By.xpath(".//*[@id='commentform']/p[1]"));
    }
}
