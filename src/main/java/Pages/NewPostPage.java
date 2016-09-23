package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class NewPostPage extends Page{

private String submit = "search-submit";

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public void submit() {
        driver.findElement(By.id(submit)).click();

    }

    public void addPosts(String title) {
        driver.findElement(By.id("title")).sendKeys(title);

        driver.findElement(By.id("content-html")).click();
        driver.findElement(By.id("content")).sendKeys(title +" " +title);
        driver.findElement(By.xpath(".//*[@id='publish']")).click();

    }
}
