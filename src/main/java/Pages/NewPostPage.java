package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class NewPostPage extends Page{

//private String submit = "search-submit";

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public void submit() {

        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='edit-slug-buttons']/button")));
        driver.findElement(By.xpath("//*[@id='publish']")).click();
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message']/p/a")));
    }

    public void addPosts(String title) {
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys(title);

       driver.findElement(By.id("content")).clear();
        driver.findElement(By.id("content")).sendKeys(title +" " +title);
        //driver.findElement(By.xpath(".//*[@id='publish']")).click();

    }
}
