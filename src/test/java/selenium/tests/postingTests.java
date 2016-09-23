package selenium.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-09-23.
 */
public class postingTests {


    private WebDriver driver;
    private AdminPage adminPage;
    private AdddingPage addingPage;
    private String content = "treść posta";
    int rand = getRandom();
    private String title = "nowy pościk";
    private AllPostPage allPostPage;
    private LogOutPage logOutPage;
    private MainPage mainPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT\\automatyzacja-2016-11\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
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

    public int getRandom() {
        int randNum = (int) (Math.random() * 1000);
        return randNum;
    }
}
