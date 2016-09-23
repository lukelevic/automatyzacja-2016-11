package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class AllPostsPage extends Page {
    private final static String DELETE_MESSAGE = "1 wpis został przeniesiony do kosza. ";

    private String postTitle;

    @FindBy(css = "#wpbody-content > div.wrap > ul > li.publish > a")
    private WebElement linkToPublishedPosts;

    @FindBy(id = "doaction")
    private WebElement applyButton;

    @FindBy(css = "#message > p")
    private WebElement afterDeleteMsg;

    @FindBy(xpath = ".//*[@id='the-list']/tr[1]/td[1]/strong/a")
    private WebElement firstPostTitle;

    public AllPostsPage(WebDriver driver) {
        super(driver);
    }

    public void showAllPublishedPosts() {
        linkToPublishedPosts.click();
    }

    public void open() {
        driver.get(baseUrl + "wp-admin/edit.php");
    }

    public void removeTopPost() {
        getTopPostTitle();
        remove();
        System.out.println("==========afterDeleteMsg.getText()============");
        System.out.println(afterDeleteMsg.getText());
        System.out.println("==========DELETE_MESSAGE============");
        System.out.println(DELETE_MESSAGE);
        Assert.assertThat(afterDeleteMsg.getText(), CoreMatchers.containsString(DELETE_MESSAGE));
        Assert.assertNotEquals(postTitle, firstPostTitle.getText());
    }

    private String getTopPostTitle() {
        postTitle = firstPostTitle.getText();

        return postTitle;
    }

    private void remove() {
        driver.findElement(By.xpath(".//*[@id='the-list']/tr[1]/th/input")).click();
        Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
        select.selectByValue("trash");
        applyButton.click();
    }
}
