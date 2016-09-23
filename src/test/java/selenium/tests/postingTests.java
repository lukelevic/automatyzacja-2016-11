package selenium.tests;

import org.junit.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-09-23.
 */
public class postingTests extends Scenario {
    private AdminPage adminPage;
    private AdddingPage addingPage;
    private String content = "treść posta";
    private String title = "nowy pościk";
    private AllPostPage allPostPage;
    private LogOutPage logOutPage;
    private MainPage mainPage;
    private PostPage postPage;
    int rand = getRandom();

    @Test@Ignore
    public void shouldAddNewPostTest() {
        LoginPage loginPage = new LoginPage(driver);
        adminPage = loginPage.logIn();
        addingPage = adminPage.goToAddingPage();
        addingPage.publishNewPost(title, content, rand);
        allPostPage = addingPage.goToAllPostView();
        logOutPage = allPostPage.logOut();
        mainPage = logOutPage.goToMainPage();
        mainPage.goToPostView(title);
        assertTrue(driver.getTitle().contains(title+" "+rand));
    }

    @Test
    public void shouldAddComment() {
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.goToMainPage();
        postPage = mainPage.goToPostView();
        postPage.clickReply();
        postPage.setComment();
        postPage.setEmail();
        postPage.setUserName();
        postPage.buttonSendClick();
    }


}
