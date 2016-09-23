package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminPage extends Page {


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "wp-admin");
    }
}
