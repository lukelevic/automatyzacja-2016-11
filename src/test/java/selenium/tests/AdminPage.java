package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class AdminPage extends Abstract {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdddingPage goToAddingPage() {
        driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")).click();
        driver.findElement(By.xpath("//div[@class='wrap']//a[text()='Dodaj nowy']")).click();
        return new AdddingPage(driver);
    }

}
