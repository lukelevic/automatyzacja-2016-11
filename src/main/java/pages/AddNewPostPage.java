package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddNewPostPage extends Page {

    @FindBy(id = "title")
    private WebElement titleInput;

    @FindBy(id = "content")
    private WebElement contentArea;

    @FindBy(id = "publish")
    private WebElement publishButton;


    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publishPost(String title, String postContent) {
        titleInput.sendKeys(title);
        contentArea.sendKeys(postContent);
        publishButton.click();
    }

    public void open() {
        driver.get(baseUrl + "wp-admin/post-new.php");
    }
}