package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class BlogPage extends Page {
    private List<WebElement> list;
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl);
    }

    public void assertPostWithTitleIsPublished(String title) {
        list  = driver.findElements(By.xpath("//*[contains(text(),'" + title + "')]"));
        Assert.assertTrue("Text " + title + " not found!", list.size() > 0);
    }
}

