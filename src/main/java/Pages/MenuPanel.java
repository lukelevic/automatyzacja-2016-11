package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPanel extends Page {

    public MenuPanel(WebDriver driver) {
        super(driver);
    }

    public void selectAddPost() {
        click(By.xpath(".//*[@id='menu-posts']/a/div[3]"));
        click(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a"));
    }

    public void selectAddTag() {
        click(By.xpath(".//*[@id='menu-posts']/a/div[3]"));
        click(By.xpath(".//*[@id='menu-posts']/ul/li[5]/a"));
    }
}
