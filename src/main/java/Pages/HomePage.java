package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-09-23.
 */
public class HomePage extends WpPage  {
    public static final String MainContent = "//div[@id='content']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openURL("");
    }

    public boolean isPostAdded(String s) {

        String content =  findElement("xpath", MainContent).getText();
        return content.contains(s);
    }
}
