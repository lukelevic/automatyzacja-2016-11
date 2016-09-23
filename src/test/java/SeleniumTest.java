import org.junit.*;
import pages.*;


public class SeleniumTest extends BaseTest {
    private static final String TITLE = "new post";
    private static final String POST_CONTENT = "new message bla bla bla bla bla bla bla bla";

    @Test
    public void publishNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.signIn();
        AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
        addNewPostPage.open();
        addNewPostPage.publishPost(setRandomTitle(TITLE), POST_CONTENT);
        MainPage mp = new MainPage(driver);
        mp.logOut();
        BlogPage bp = new BlogPage(driver);
        bp.open();
        bp.assertPostWithTitleIsPublished(newTitle);
    }

    @Test
    public void removeBlogPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.signIn();
        AllPostsPage allPostsPage = new AllPostsPage(driver);
        allPostsPage.open();
        allPostsPage.showAllPublishedPosts();
        allPostsPage.removeTopPost();
    }

}