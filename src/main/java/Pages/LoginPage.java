package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class LoginPage extends Page{

   String  baseUrl = "https://automatyzacja2016.wordpress.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void goToLogin() {

            driver.get(baseUrl + "/");
            driver.get(baseUrl + "/wp-login.php");

    }

    public AdminMainPage signLogin(String user, String password) {
        driver.findElement(By.xpath(".//*[@id='user_login']")).click();
       driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys(user);
        driver.findElement(By.xpath(".//*[@id='user_pass']")).click();
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();


        return new AdminMainPage(driver);
    }



}
