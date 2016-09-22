import org.junit.*;
import org.openqa.selenium.By;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016-09-22.
 */
public class WpPostTest extends WpTest {

    @Test
    public void ShouldAddNewPost() throws Exception {
        // given
        String title = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        String msg = "This is auto-generated test for JUnit.";

        // when
        click(By.xpath("//li[@id='wp-admin-bar-ab-new-post']//a"));
        insert(By.className("editor-title__input"), title);
        insert(By.id("tinymce-1"), msg);
        click(By.className("editor-ground-control__publish-button"));

        // then
        Assert.assertTrue(driver.findElement(By.className("notice__content")).isDisplayed());
    }
}