package rst.wordpress;

import org.apache.xpath.operations.Equals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016-09-23.
 */
public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isPostAdded(String title) {
        driver.get(baseUrl + "/");
        return title.equals(driver.findElement(By.linkText(title)).getText());
    }

    public HomePage goToMainPage(WebDriver driver) {
        driver.get(baseUrl + "/");
        return new HomePage(driver);
    }
    public SinglePost goToFirstMyPost() {
        driver.findElement(By.xpath("//*[@id=\"categories-3\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id]/header/div/a/span")).click();
        return new SinglePost(driver);
    }
}
