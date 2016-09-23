package selenium.tests;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class LogOutPage extends Abstract {
    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToMainPage() {
        driver.get(baseUrl);
        return new MainPage(driver);
    }
}
