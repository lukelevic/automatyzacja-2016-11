import java.util.Random;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest extends BaseTest {

    @Test
    public void shouldLogIntoPage() throws Exception {
        open("/wp-admin");
        login("szkolenieautomatyzacja", "QW12qw12");
        Assert.assertTrue(driver.getTitle().contains("Kokpit"));
        logout();
        Assert.assertTrue(driver.getTitle().contains("WordPress.com: Create a free website or blog"));
    }

    @Test
    public void ShouldAddNewPost() {
        String title = "Title:"+getRandomString();
        String post ="Text:"+getRandomString();

        open("/wp-admin");
        login("szkolenieautomatyzacja", "QW12qw12");

        addNewPost(title, post);

        logout();

        //check if post is added
        open("");

        WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='masthead']/hgroup/h1/a")));

        Assert.assertTrue("Nie ma postu o tytule: "+title,driver.getPageSource().contains(title));
        Assert.assertTrue("Nie ma postu o tresci: "+post,driver.getPageSource().contains(post));
    }



}
