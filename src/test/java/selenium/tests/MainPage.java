package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class MainPage extends Abstract {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToPostView(String title) {
        driver.findElement(By.xpath("//div[@id='content']//a[contains(text(),'"+title+"')]")).click();
    }
}
