package SeleniumTests;

import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class AddBlogPostTest {

    private WebDriver driver;


    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//        System.setProperty("webdriver.chrome.driver","/usr/share/chromedriver/chromedriver/");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void shouldPublishPost() {
        String title = UUID.randomUUID().toString();
        String text = UUID.randomUUID().toString();

        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);

        loginPage.open();
        AdminPage adminPage = loginPage.signIn();

        adminPage.addPost(title,text);
        adminPage.publish();

        loginPage.logOut();

        postsPage.open();
        Assert.assertTrue(postsPage.isPostPublished(title, text));
    }

    @Test
    public void shouldAddNewTagTest() {
        String name = UUID.randomUUID().toString();
        String description = UUID.randomUUID().toString();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        AdminPage adminPage = loginPage.signIn();

        adminPage.addTag(name, description);

        adminPage.publishTag();
        adminPage.waitForElementOnPage(name, 1000);

        Assert.assertTrue(adminPage.isTagPublished(name, description));
        loginPage.logOut();
    }

    @Test
    public void shouldAddNewCommentToPostTest() {
        LoginPage loginPage = new LoginPage(driver);
        PostsPage postsPage = new PostsPage(driver);
        String comment = UUID.randomUUID().toString();

        loginPage.open();
        loginPage.signIn();

        postsPage.open();
        Post post = postsPage.openPost();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        post.addComment(comment);
        post.publishComment();

        post.waitForElementOnPage(comment,5000);

        Assert.assertTrue(post.isPostPublished(comment));

        loginPage.logOut();
    }
}
