package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdddingPage extends Abstract{
    public AdddingPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewPost(String title, String content, Integer random) {
        driver.findElement(By.xpath("//div[@id='titlediv']//input[@id='title']")).sendKeys(title+" "+random);
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys(content);
        driver.findElement(By.xpath("//input[@id='publish']")).click();
    }

    public AllPostPage goToAllPostView() {
        driver.findElement(By.xpath("//li[@id='menu-posts']//a[@class='wp-first-item current']")).click();
        return new AllPostPage(driver);
    }
}
