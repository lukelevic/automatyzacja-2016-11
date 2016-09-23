package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void addPost(String title, String text) {
        MenuPanel menuPanel = new MenuPanel(driver);

        menuPanel.selectAddPost();

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

    public void addTag(String name, String description) {
        MenuPanel menuPanel = new MenuPanel(driver);

        menuPanel.selectAddTag();

        insert(By.xpath(".//*[@id='tag-name']"), name);
        insert(By.xpath(".//*[@id='tag-description']"), description);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void publishTag() {
        click(By.xpath(".//*[@id='submit']"));
    }

    public boolean isTagPublished(String name, String description) {
        if (!driver.getPageSource().contains(name)) {
            return false;
        }
        if (!driver.getPageSource().contains(description)) {
            return false;
        }
        return true;
    }
}
