package rst.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class Page  {
    public final WebDriver driver;
    public String baseUrl = "https://automatyzacja2016.wordpress.com/";
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void insertText(By where, String text) {
        //new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(where));
        driver.findElement(where).clear();
        driver.findElement(where).sendKeys(text);
    }
    protected void clickElement(By where) {
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(where));
        driver.findElement(where).click();
    }

    public void closeBrowser() {
        driver.get(baseUrl + "/wp-admin");
        clickElement(By.cssSelector("img.avatar.avatar-32"));
        //new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")));
        //KliknijXpath("//*[@id=\"wp-admin-bar-user-info\"]/div/form/button");

        new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ab-sign-out")));
        clickElement(By.cssSelector("button.ab-sign-out"));
    }
}
