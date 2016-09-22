import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SeleniumTest extends BaseTest {
    private String newTitle;
    private List<WebElement> list;

    private static final String TITLE = "new post";
    private static final String POST_CONTENT = "new message bla bla bla bla bla bla bla bla";

    @Test
    public void testCase() throws Exception {
        open("wp-login.php");
        logIn("szkolenieautomatyzacja", "QW12qw12");
        publishPost(TITLE, POST_CONTENT);
        logOut();
        open("");
        scrollDown();
        collectAllTitles();
        Assert.assertTrue("Text " + newTitle + " not found!", list.size() > 0);
    }

    private void publishPost(String postTitle, String postMessage) {
        open("wp-admin/post-new.php");

        newTitle = generateNewTitle(postTitle);
        driver.findElement(By.id("title")).sendKeys(newTitle);
        driver.findElement(By.id("content")).sendKeys(postMessage);
        driver.findElement(By.id("publish")).click();
    }

    private void collectAllTitles() {
        list = driver.findElements(By.xpath("//*[contains(text(),'" + newTitle + "')]"));
    }

    private String generateNewTitle(String title) {
        Random generator = new Random();
        int i = generator.nextInt(10000);

        return title + i;
    }
}