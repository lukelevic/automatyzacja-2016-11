package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AllPostPage extends Page{
    public AllPostPage(WebDriver driver) {
        super(driver);
    }



    public void searchPost(String title) {
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath("//*[@id='post-search-input']")).sendKeys(title);
        driver.findElement(By.id("search-submit")).click();
        System.out.println(title);
        Assert.assertTrue(driver.getPageSource().contains(title));

    }

    public void openPostPage() {
        driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();

    }
}
