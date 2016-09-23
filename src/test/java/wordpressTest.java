import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;



public class wordpressTest extends baseClass {

    public void publishPostWithBody(String title, String body)
    {
        // when
        findByXpathAndClick(NewPostSelector);
        findElement("xpath", PostTitleSelector).sendKeys(title);
        findElement("xpath", PostTextSelector).sendKeys(body);
        findByXpathAndClick(NewPostPublishSelector);
    }

    @Test
    public void testShouldLogin() throws Exception {
        String login = "szkolenieautomatyzacja";
        String password = "QW12qw12";

        // given
        openURL("");

        // when
        login(login, password);

        // then
        Assert.assertTrue(isLogged());
    }

    @Test
    public void testShouldAddPost() throws Exception {

        // given
        Random generator = new Random();
        int a = generator.nextInt(50000);
        String expectedPostString = "Post testowy z selenium: " + a;
        String expectedTitleString = "Tytuł testowy z selenium";

        // when
        publishPostWithBody(expectedTitleString, expectedPostString);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NoticeSelector)));

        findElement("xpath", AvatarSelector).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (NoSuchElementException e) {  }

        logout();
        openURL("");

        // then
        String content =  findElement("xpath", MainContent).getText();
        Assert.assertTrue(content.contains(expectedPostString));

    }


}
