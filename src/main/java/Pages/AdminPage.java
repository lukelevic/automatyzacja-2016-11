package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdminPage extends WpPage {

    public static final String NewPostSelector = "//li[@id='wp-admin-bar-ab-new-post']";
    public static final String PostTitleSelector = "//textarea[@class='textarea-autosize editor-title__input']";
    public static final String PostTextSelector = "//textarea[@id='tinymce-1']";
    public static final String NewPostPublishSelector = "//button[@class='editor-ground-control__publish-button button is-primary']";
    public static final String NoticeSelector = "//div[@class='notice__content']";

    public static final String AvatarSelector = "//img[@class='gravatar']";
    public static final String AvatarSelector2 = "//img[contains(@class, 'avatar')]";

    public static final String LogoutSelector = "//button[@class='button me-sidebar__signout-button is-compact']";

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPost(String testString) {

        String titleString = "PD Tytuł testowy z selenium";

        findByXpathAndClick(NewPostSelector);
        findElement("xpath", PostTitleSelector).sendKeys(titleString);
        findElement("xpath", PostTextSelector).sendKeys(testString);
        findByXpathAndClick(NewPostPublishSelector);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NoticeSelector)));
    }

    public boolean isLogged()
    {
        if ( ( findElement("xpath", AvatarSelector2) != null )) return true;
        else return false;
    }

    public void logOut() {
        findElement("xpath", AvatarSelector2).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (NoAlertPresentException e) {  }

        findElement("xpath", LogoutSelector).click();
    }
}
