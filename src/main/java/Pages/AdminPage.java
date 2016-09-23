package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void addPost(String title, String text) {
        //TODO:select from menu
        click(By.xpath(".//*[@id='menu-posts']/a/div[3]"));
        click(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a"));

        insert(By.xpath(".//*[@id='title']"), title);
        click(By.xpath(".//*[@id='content-html']"));
        insert(By.xpath(".//*[@id='content']"), text);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void publish() {
        click(By.xpath(".//*[@id='publish']"));

        WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(".//*[@id='publish']"),"Zaktualizuj"));
    }

}
