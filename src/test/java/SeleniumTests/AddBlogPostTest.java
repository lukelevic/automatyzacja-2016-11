package SeleniumTests;

import Pages.AdminPage;
import Pages.LoginPage;
import Pages.PostsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class AddBlogPostTest {
    private String title = UUID.randomUUID().toString();
    private String text = UUID.randomUUID().toString();
    private WebDriver driver;


    @Before
    public void setUp() {
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
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        AdminPage adminPage = loginPage.signIn();

        adminPage.addPost(title,text);
        adminPage.publish();

        PostsPage postsPage = new PostsPage(driver);

        loginPage.logOut();

        postsPage.open();

        Assert.assertTrue(postsPage.isPostPublished(title, text));
    }
}
