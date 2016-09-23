import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest extends Scenario {






    @Test
    public void ShouldLoginWithCredential() throws Exception {
        //given
        login();


        //when
        //TODO login(user,password)
    }



    @Test
    public void ShouldAddPost() throws Exception {
        login();
        addNewPost();
        assertAddPost();

    }


}
