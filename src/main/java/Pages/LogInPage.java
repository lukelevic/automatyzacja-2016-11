package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class LogInPage extends Page {



    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {

        driver.get(baseUrl + "wp-admin");

    }

    public MainPage logIn() {
        insert(By.id("user_login"), "szkolenieautomatyzacja");
        insert(By.id("user_pass"), "QW12qw12");
        click(By.id("wp-submit"));


        return new MainPage(driver);
    }




        protected void click(By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

         protected void insert(By login, String text) {
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(text);
    }


    }



