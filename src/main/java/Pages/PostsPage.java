package Pages;

import org.openqa.selenium.WebDriver;

public class PostsPage extends Page {

    public PostsPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL);
    }

    public boolean isPostPublished(String title, String text) {

        if (!driver.getPageSource().contains(title)) {
            return false;
        }
        if (!driver.getPageSource().contains(text)) {
            return false;
        }

        return true;
    }

    public Post findPost() {
        return null;
    }
}
