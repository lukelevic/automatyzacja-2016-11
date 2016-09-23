package Pages;

import Pages.Page;
import Pages.PostPreviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-09-23.
 */
public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);

    }

    public void addNewPost(String title) throws InterruptedException {


         Thread.sleep(3000);
        xpathSendKeyTitle(".//*[@id='primary']/div/div[2]/div[1]/div[2]/div[3]/div/textarea", title); // potzrena dwoch wartosci do moetody

    }



    public PostPreviewPage goToPostPreviewPage() throws InterruptedException {
        Thread.sleep(1000);
        click(By.xpath(" .//*[@id='primary']/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/button[1]"));

        return new PostPreviewPage(driver);
    }


}
