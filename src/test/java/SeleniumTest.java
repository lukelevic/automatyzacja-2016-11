import org.junit.*;
import pages.AdminPage;
import pages.BlogPage;
import pages.LoginPage;
import pages.MainPage;


public class SeleniumTest extends BaseTest {
    private static final String TITLE = "new post";
    private static final String POST_CONTENT = "new message bla bla bla bla bla bla bla bla";

    @Test
    public void publishNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        AdminPage ap = lp.signIn();
        ap.open();
        ap.publishPost(setRandomTitle(TITLE), POST_CONTENT);
        MainPage mp = new MainPage(driver);
        mp.logOut();
        BlogPage bp = new BlogPage(driver);
        bp.open();
        bp.assertPostWithTitleIsPublished(newTitle);
    }
}