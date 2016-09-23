package SeleniumTest;

import Pages.*;
import org.junit.Test;
import org.omg.CORBA.portable.Streamable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class postTest extends Page {

    private WebDriver driver;
    String password = "QW12qw12";
    String user = "szkolenieautomatyzacja";
    private Date data;

    public postTest(WebDriver driver) {
        super(driver);
    }


    @Test
    public void shouldLogin() {
        java.util.Date date = new java.util.Date();
        data = new Timestamp(date.getTime());
        String title;
        String reportDate = data.toString();
        title = reportDate + " seba";
        System.out.println(title);
        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();
        AdminMainPage amp = lp.signLogin(user, password);
        NewPostPage npp = amp.goTOAddPost();
        npp.addPosts(title);
        npp.submit();
        AllPostPage app = new AllPostPage(driver);
        app.openPostPage();
        app.searchPost(title);


    }


}
