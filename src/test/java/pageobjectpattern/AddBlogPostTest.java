package pageobjectpattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AddBlogPostTest extends Scenario {
    private static String title;

    @BeforeClass
    public static void setUpTitle() {
        title = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void shouldAddNewBlogPostTest() throws Exception {
        String msg = "This is auto-generated test for JUnit.";

        // when
        WpPostPage postPage = mainAdminPage.clickAdminBarAddNewBlogPostButton();
        postPage.addNewPostAndPublish(title, msg);

        // then
        postPage.assertNewBlogPostAlertIsDisplayed();
    }

    @Test
    public void shouldNewlyAddedPostBeOnThePostsListTest() throws Exception {
        // given
        WpAdminPostListPage postListPage = new WpAdminPostListPage(driver);
        postListPage.open();

        // then
        postListPage.isPostOnTheList(title);
    }
}
