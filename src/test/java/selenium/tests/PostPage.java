package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class PostPage extends Abstract{
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void clickReply() {
        driver.findElement(By.xpath("//span[@class='leave-reply']")).click();
    }


    public void setComment() {
        driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("hue hue");
    }

    public void setEmail() {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mua@gmail.com");
    }

    public void setUserName() {
        driver.findElement(By.xpath("//input[@id='author']")).sendKeys("lukaszl");
    }

    public void buttonSendClick() {
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    }

}
