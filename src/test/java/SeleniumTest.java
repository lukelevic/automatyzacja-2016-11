import org.junit.*;

public class SeleniumTest extends BaseTest {
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
        assertPostWithTitleExists(newTitle);
    }
}